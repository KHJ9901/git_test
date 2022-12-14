<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file = "../common.jsp" %>

<link rel="stylesheet" href="/css/dictionary.css">

<div class="wholePage">
	<div class="headContainer">
		<div class="headCategory">
			<%@ include file  = "../dictionary/dicCommonBar.jsp" %>
		</div>
	</div>
	<div class="headContainer2">
		<div class="headNotice">
			<h1>식물사전</h1>
		</div>
		
		<div class="headSubTitle">본인에게 어울리는 식물을 식물사전에서 검색해 보아요
		</div>
	</div>
	
	<div class="dicSearch">
		<form name="dicSearchForm" method="post" action="dictionary">
			<input type="hidden" name="currentPage" value="${pageMaker.cri.currentPage}" />
			
			<input class="searchText" type="text" name="searchText" placeholder="검색하세요" 
				value="${pageMaker.cri.searchText}">
			<input type="button" value="검색" onclick="document.forms['dicSearchForm'].submit()">
		</form>
	</div>
	
	<script>
		function goAction() {
			document.forms["dicSearchForm"].submit();
		}
	</script>

	<div class="searchBody">
		<div class="searchContentWrap">
			<c:forEach items="${diction}" var="dic">
				<a href="/dic/dicDetail?seqno=${dic.seqno}">
				
					<div class="searchContent">
							<c:set value="${dic.dicthumb.fileType}" var="filetype" />
								<c:set value="${fn:substring(filetype, 0, fn:indexOf(filetype, '/')) }" var="type" />
								
								<c:if test="${type eq 'image'}">
									<c:set value="${dic.dicthumb.fileName}" var="thumb_file" />
									<img src="/plant/thumb/${thumb_file}">
								</c:if>
								<p>${dic.kname}</p>
					</div>
					
				</a>
			</c:forEach>
		</div>

	</div>
	
</div>

<%@ include file = "../footer.jsp" %>