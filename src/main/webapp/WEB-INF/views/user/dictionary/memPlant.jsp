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
			<h1>회원이 등록한 식물</h1>
		</div>
		
		<div class="headSubTitle">회원들이 등록한 식물이에요. 참고하시기 바랍니다 
		</div>
		
		<%-- <c:if test="${loginuser != null }"> --%>
			<div class="wrap">
				<a href="/dic/mpInsertForm" class="mybutton">식물등록</a>
			</div>
		<%-- </c:if> --%>
		
	</div>
	
	<div class="dicSearch">
		<form name="mpSearchForm" method="post" action="mplant">
			<input type="hidden" name="currentPage" value="${pageMaker.cri.currentPage}" />
			
			<input class="searchText" type="text" name="searchText" placeholder="검색하세요" 
				value="${pageMaker.cri.searchText}">
			<input type="button" value="검색" onclick="document.forms['mpSearchForm'].submit()">				
		</form>
	</div>
	
	<script>
		function goAction() {
			document.forms["mpSearchForm"].submit();
		}
	</script>
					


	<div class="searchBody">
		<div class="searchContentWrap">
		
			<c:forEach items="${mplant}" var="mp">
				<a href="/dic/mplantDetail?seqno=${mp.mplant_seqno}">
				
					<div class="searchContent">
							<c:set value="${mp.mplant_thumb.fileType}" var="filetype" />
								<c:set value="${fn:substring(filetype, 0, fn:indexOf(filetype, '/')) }" var="type" />
								
								<c:if test="${type eq 'image'}">
									<c:set value="${mp.mplant_thumb.fileName}" var="thumb_file" />
									<img src="/plant/thumb/${thumb_file}">
								</c:if>
								<p>${mp.name}</p>
					</div>
				</a>
			</c:forEach>
			
		</div>
		


	</div>
	
</div>

<%@ include file = "../footer.jsp" %>