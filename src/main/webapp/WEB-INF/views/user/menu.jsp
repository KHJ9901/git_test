<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="w3-top">
  <div class="w3-bar" id="myNavbar">
    <a class="w3-bar-item w3-button w3-hover-black w3-hide-medium w3-hide-large w3-right" href="javascript:void(0);" onclick="toggleFunction()" title="Toggle Navigation Menu">
      <i class="fa fa-bars"></i></a>
    <a href="/index.jsp" class="w3-bar-item w3-button">식물플래너</a>
    <a href="/dic/dictionary" class="w3-bar-item w3-button w3-hide-small">식물사전</a>
    <a href="/ao/adopt" class="w3-bar-item w3-button w3-hide-small">분양</a>
    <a href="/bo/board" class="w3-bar-item w3-button w3-hide-small">게시판</a>
    <c:set value="${loginUser}" var = "loginuser"/>
    <c:if test="${loginuser != null}">
	    <a href="/do/diary" class="w3-bar-item w3-button w3-hide-small">식물일기</a>
	    <a href="/lo/logout" class="w3-bar-item w3-button w3-hide-small w3-right"><i class="fa fa-board"></i>로그아웃</a>
	    <a href="/me/mypage" class="w3-bar-item w3-button w3-hide-small w3-right"><i class="fa fa-board"></i>마이페이지</a>
    </c:if>
    <c:if test="${loginuser eq null}">
    	<a href="/lo/loginview" class="w3-bar-item w3-button w3-hide-small w3-right"><i class="fa fa-board"></i>로그인</a>
    </c:if>
  </div>




  <!-- Navbar on small screens -->
  <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium">
    <a href="#about" class="w3-bar-item w3-button" onclick="toggleFunction()">ABOUT</a>
    <a href="#portfolio" class="w3-bar-item w3-button" onclick="toggleFunction()">PORTFOLIO</a>
    <a href="#contact" class="w3-bar-item w3-button" onclick="toggleFunction()">CONTACT</a>
    <a href="#" class="w3-bar-item w3-button">SEARCH</a>
  </div>
</div>