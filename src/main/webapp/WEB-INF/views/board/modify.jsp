<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Front page</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700,900" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="responsive.css">
    <link rel="stylesheet" href="/css/modify.css?ver=1">

    <%@ include file="../include/header.jsp" %>

    <style>
    </style>
</head>

<body>
    <div class="wrapper">
        <header class="header">
            <div class="container">
                <div class="row">
                    <div class="col-md-2">
                        <div class="logo">
                            <h2><a href="/">My Blog</a></h2>
                        </div>
                    </div>
                    <div class="col-md-10">
                        <div class="menu">
                            <ul>
                                 <li class="active"><a href="#">홈</a></li>
                                 <li><a href="/board/movie-list">영화</a></li>
                                 <li><a href="/board/restaurant-list">맛집</a></li>
                                 <li><a href="/board/daily-list">일상</a></li>
                                 <li><a href="/board/guest-book">방명록</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </header>




        <section class="write">

            <h1>BLOG 게시물 수정</h1>

            <div class="inputmenu">

                <form action="/board/modify" method="POST">
                      <input type="hidden" class="input" name="categoryNo" value="${article.categoryNo}">
                    <input type="hidden" class="input" name="serialNo" value="${article.serialNo}">
                    <input id="title" type="text" class="input" name="boardTitle" placeholder="제목을 입력하세요." value="${article.boardTitle}"><br>
                    <br>
                    <textarea id="textArea" rows="60" class="input" cols="40"  name="boardContent" placeholder="내용을 입력하세요.">${article.boardContent}</textarea><br>


                    <button type="submit">수정</button>
                </form>

            </div>

<c:set var="categoryNo" value="${article.categoryNo}" />

<c:choose>
    <c:when test="${categoryNo eq '1'}">
        <a id="boardlist" href="/board/movie-list" style="text-decoration: none;">글 목록보기</a>
    </c:when>
    <c:when test="${categoryNo eq '2'}">
        <a id="boardlist" href="/board/restaurant-list" style="text-decoration: none;">글 목록보기</a>
    </c:when>
    <c:when test="${categoryNo eq '3'}">
        <a id="boardlist" href="/board/daily-list" style="text-decoration: none;">글 목록보기</a>
    </c:when>
</c:choose>



        </section>

        <footer class="footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="footer-bg">
                            <div class="row">
                                <div class="col-md-9">
                                    <div class="footer-menu">
                                        <ul>
                                            <li class="active"><a href="#">Home</a></li>
                                            <li><a href="#">lifestyle</a></li>
                                            <li><a href="#">Food</a></li>
                                            <li><a href="#">Nature</a></li>
                                            <li><a href="#">photography</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="footer-icon">
                                        <p><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a><a
                                                href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a><a
                                                href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a><a
                                                href="#"><i class="fa fa-dribbble" aria-hidden="true"></i></a></p>
                                    </div>
                                </div>
                            </div> .
                        </div>
                    </div>
                </div>
            </div>
        </footer>
    </div>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/active.js"></script>
</body>

</html>