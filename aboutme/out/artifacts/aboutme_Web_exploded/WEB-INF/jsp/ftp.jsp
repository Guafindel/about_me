<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <title>자기소개</title>
        <link href="css/style.css" rel="stylesheet" />
    </head>
    <body>
        <%@ include file="/WEB-INF/jsp/common/header.jsp" %>
        <div class="content">
            <div class="time-content">
                <div class="time-content-item">
                    <h1>현재 시간은</h1>
                    <p id="now-date">${nowDate}</p>
                </div>
            </div>
            <div class="ftp-content">
                <c:forEach var="dir" items="${dirList}" varStatus="dirStatus">
                    <a class="ftp-item" href="${requestUrl}${dir.dirUrl}">
                        <img class="icon" src="img/icon-folder.png" />
                        <span>${dir.dirName}</span>
                    </a>
                </c:forEach>
                <c:forEach var="file" items="${fileList}" varStatus="fileStatus">
                    <a class="ftp-item" href="${requestUrl}${file.fileUrl}">
                        <img class="icon" src="img/icon-file.png" />
                        <span>${file.fileName}</span>
                    </a>
                </c:forEach>
            </div>
        </div>
        <input type="hidden" id="nowDate" value="${nowDate}">
        <script src="js/time.js"></script>
        <%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
    </body>
</html>
