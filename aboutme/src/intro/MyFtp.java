package intro;

import org.apache.commons.net.ftp.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class MyFtp
 */
@WebServlet("/my-ftp")
public class MyFtp extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MyFtp() {
        super();
    }

    private FTPClient ftpClient;

    private final ServerInfo serverInfo = new ServerInfo();

    private void openFtpClient() throws IOException {
        this.ftpClient = new FTPClient();

        FTPClientConfig ftpConfig = new FTPClientConfig();
        ftpConfig.setServerTimeZoneId(serverInfo.serverTimeZone);
        ftpClient.configure(ftpConfig);
        ftpClient.setControlEncoding(serverInfo.serverEncoding);

        try {
            int reply;
            String serverUri = serverInfo.serverUri;
            ftpClient.connect(serverUri);
            ftpClient.login(serverInfo.userName, serverInfo.userPassword);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            System.out.println("Connected to " + serverUri + ".");
            System.out.print(ftpClient.getReplyString());

            // After connection attempt, you should check the reply code to verify
            // success.
            reply = ftpClient.getReplyCode();

            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                System.err.println("FTP server refused connection.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            ftpClient.disconnect();
        }
    }

    public void closeFtpClient() {
        try {
            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                    // do nothing
                }
            }
        }
    }

    public List<Map<String, String >> makeFileList(FTPFile[] ftpFiles, String dirParam, String fileType) {
        List<Map<String, String>> fileList = new ArrayList<Map<String, String>>();

        for (FTPFile file: ftpFiles) {
            Map<String, String> fileMap = new HashMap<>();
            String fileName = fileType.equals("FILE") ? file.getName() : "[" + file.getName() + "]";
            String fileUrl = dirParam + file.getName();
            fileMap.put(fileType.equals("FILE") ? "fileName" : "dirName", fileName);
            fileMap.put(fileType.equals("FILE") ? "fileUrl" : "dirUrl", fileUrl);
            fileList.add(fileMap);
        }

        return fileList;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");

        LocalDateTime time = LocalDateTime.now();
        String nowDate = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        List<Map<String, String>> dirList = new ArrayList<>();
        List<Map<String, String>> fileList = new ArrayList<>();
        String nowDir = "";
        try {
            openFtpClient();

            String dirParam = request.getParameter("dir");
            nowDir = dirParam;

            if(dirParam == null || dirParam.isEmpty()) {
                dirParam = "/";
                nowDir = dirParam;
            } else {
                dirParam = dirParam + "/";
            }

            dirList = makeFileList(ftpClient.listFiles(dirParam, FTPFile::isDirectory), dirParam, "DIRECTORY");
            fileList = makeFileList(ftpClient.listFiles(dirParam, FTPFile::isFile), dirParam, "FILE");

            if(!dirParam.equals("/")) {
                String parentDir = dirParam.substring(0, nowDir.lastIndexOf("/"));
                Map<String, String> parentMap = new HashMap<>();
                parentMap.put("dirName", "...");
                parentMap.put("dirUrl", parentDir);
                dirList.add(0, parentMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeFtpClient();
        }

        request.setAttribute("nowDate", nowDate);
        request.setAttribute("dirList", dirList);
        request.setAttribute("fileList", fileList);
        request.setAttribute("nowDir", nowDir);
        request.setAttribute("sourcePath", nowDir);
        request.setAttribute("requestUrl", "/aboutme/my-ftp?dir=");

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/myftp.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
