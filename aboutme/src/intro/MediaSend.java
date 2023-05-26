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
@WebServlet("/media-send")
public class MediaSend extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MediaSend() {
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");

        try {
            openFtpClient();

//            String sourcePath = request.getParameter("sourcePath");

            String sourcePath = "/HDD1/luda/luda.mp4";

//            String destinationPath = "/Users/developer/Downloads/luda.mp4";
//
//            File downloadFile1 = new File(destinationPath);
//            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
//            boolean success = ftpClient.retrieveFile(sourcePath, outputStream1);
//            outputStream1.close();
//
//            if (success) {
//                System.out.println("File #1 has been downloaded successfully.");
//            }

            InputStream inputStream = ftpClient.retrieveFileStream(sourcePath);

            boolean success2;

            response.setContentType("video/mp4");
            response.setHeader("Accept-Ranges", "bytes");
            response.setHeader("Content-Disposition", "inline; filename=luda.mp4");

            ServletOutputStream outputStream = response.getOutputStream();

            byte[] outputByte = new byte[4096];
            int read = 0;
            while((read = inputStream.read(outputByte)) != -1) {
                outputStream.write(outputByte, 0, read);
            }

            inputStream.close();
            outputStream.flush();
            outputStream.close();

            success2 = ftpClient.completePendingCommand();
            if (success2) {
                System.out.println("File #2 has been downloaded successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeFtpClient();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
