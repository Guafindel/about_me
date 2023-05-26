<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
            <div class="introduce-text">
                <h1>웹 개발자 Guifindel</h1>
                <p>웹 개발자</p>
                <p>모바일팩토리 소속, 안양 물류센터 근무</p>
            </div>
            <div class="link-box">
                <p class="link-box-item"><a class="menu-link" href="/aboutme/about-me">자기소개</a></p>
                <p class="link-box-item"><a class="menu-link" href="/aboutme/my-photo">사진</a></p>
            </div>
            <div class="photo-box">
                <img class="photo-box-item" src="img/image_0001.jpg" />
            </div>
        </div>
        <%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
    </body>
</html>
