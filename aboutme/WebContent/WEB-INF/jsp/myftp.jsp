<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html lang="ko">
<head>
    <title>Striped by HTML5 UP</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">
    <link rel="stylesheet" href="css/main.css" />
    <link rel="stylesheet" href="css/video-js.min.css">
</head>
<body class="is-preload">
<!-- Content -->
<div id="content">
    <div class="inner">
        <!-- Post -->
        <article class="box post post-excerpt">
            <header>
                <!--
                    Note: Titles and subtitles will wrap automatically when necessary, so don't worry
                    if they get too long. You can also remove the <p> entirely if you don't
                    need a subtitle.
                -->
                <h3><a href="#">${nowDir}</a></h3>
                <p>A tiny space that personal, secret, connect thing</p>
            </header>
            <a href="#" class="image featured">
                <video
                        id="my-video"
                        class="video-js"
                        controls
                        preload="auto"
<%--                        poster="img/pic01.jpg"--%>
                >
<%--                    <source src="video/luda.mp4" type="video/mp4" />--%>
<%--                    <source src="http://175.210.27.181:9000/httpstream/guifindel/HDD1/luda/luda.mp4" type="video/mp4" />--%>
<%--                    <source src="ftp://guifindel:flatworld90@guifindel.ipdisk.co.kr/HDD1/luda/luda.mp4" type="video/mp4" />--%>
                        <source src="/aboutme/media-send?${nowDir}" type="video/mp4" />


                </video>
            </a>
<%--            <a href="#" class="image featured"><img src="img/pic01.jpg" alt="" /></a>--%>
        </article>
    </div>
</div>
<!-- Sidebar -->
<div id="sidebar">
    <!-- Logo -->
    <h1 id="logo"><a href="/aboutme"><img src="img/icon-graycat.png" style="width: 25px;" /></a></h1>
    <!-- Nav -->
    <nav id="nav">
        <ul>
            <c:forEach var="dir" items="${dirList}" varStatus="dirStatus">
                <li><a href="${requestUrl}${dir.dirUrl}">${dir.dirName}</a></li>
            </c:forEach>
            <c:forEach var="file" items="${fileList}" varStatus="fileStatus">
                <li><a href="${requestUrl}${file.fileUrl}">${file.fileName}</a></li>
            </c:forEach>
        </ul>
    </nav>
</div>

<!-- Scripts -->
<script src="js/jquery.min.js"></script>
<script src="js/browser.min.js"></script>
<script src="js/breakpoints.min.js"></script>
<script src="js/util.js"></script>
<script src="js/main.js"></script>
<script src="js/ftp.js"></script>
<script src="js/video.min.js"></script>
</body>
</html>