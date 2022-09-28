<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file = "../common.jsp" %>
<link rel="stylesheet" href="/css/detailPage.css">

<div class="wholeDetail">

	<div class="detailHead">
	<c:set value="${mplantdetail}" var="md" />
		<c:forEach items="${md.mpimg}" var="mpimg" >
		
			<c:set value="${mpimg.fileType}" var="mpitype" />
			
			<div class="detailImg">
			
				<c:set value="${fn:substring(mpitype, 0, fn:indexOf(mpitype, '/'))}" var="type" />
				
				<c:if test="${type eq 'image'}">
					<c:set value="${mpimg.fileName}" var="img_file" />
					<img src="/plant/${img_file}">
				</c:if> 
			</div>
		</c:forEach>
		
		<div class="detailHeadTitle">
		
			<div class="detailSubTitle">
			
				<div class="cateHeart">
				
					<div class="categoryWrap">
					
						<div class="detailCategory">회원이 등록한 식물
						</div>
						
						<div class="detailCategory">${md.cate}</div>
						
					</div>
					
					<div class="heartDiv">
						<button type="button" class="heart">♡</button>
					</div>
				</div>
				
				<div class="plantName">
					<div class="kname">${md.name}</div>
				</div>
			
				<div class="advice">
					<div class="adviceText">키우는 난이도가 어땠나요?</div>
					<div class="levelText">
					 난이도 :
						<c:if test="${md.plevel == 'e'}" > 쉬움 </c:if>
						<c:if test="${md.plevel == 'h'}" > 어려움 </c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<hr class="firstHr">
	
	<div class="water">
		<h2>물은 이렇게 주세요</h2>
		<div>${md.water}</div>
	</div>
	
	<hr class="secondHr">
	
	<div class="place">
		<h2>이런 장소를 좋아해요</h2>
		<div>${md.place}</div>
	</div>
		
	<hr class="thirdHr">
	
	<div class="moist">
		<h2>온도와 습도는 이렇게 맞춰주세요</h2>
		<div>온도 : ${md.temp}</div>
		<div>습도 : ${md.moist}</div>
	</div>
		
	<hr class="forthHr">
	
	<div class="etc">
		<h2>이런 부분은 더 신경 써주세요</h2>
		<div>${md.etc}</div>
	</div>
		
	<hr class="fifthHr">
	
	<c:set value="${loginUser}" var="user" />
			
	<c:if test="${user.id eq md.id}">
		<a href="/dic/mpModify?seqno=${md.mplant_seqno}">수정</a>
		<a href="/dic/deleteMplant?seqno=${md.mplant_seqno}'">삭제</a>
	</c:if>
	
	<c:if test="${user.id != md.id}">
		<div class="detailQuestion">
			<h2>질문하기</h2>
			<div>
				<div>식물이 아프거나 키우기 어렵다면 다른 식집사 분들의 도움을 받아보세요.</div>
			</div>
			<div class="questionBt">
				<button type="button" onclick="location.href='qeustion.jsp'">질문</button>
			</div>
		</div>
	</c:if>

</div>
	<script>
	function del_confirm(seqno) {
		var rs = confirm('정말로 삭제하시겠습니까?');
		if(rs) {
			location.href="boardDelete?seqno=" + seqno;
		}
	}
	</script>	
<%@ include file = "../footer.jsp" %>