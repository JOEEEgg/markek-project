<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="css/form.css">
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function() {

	
	
	
	$("form").on("submit", function(event) {
		var userid = $("#userid").val();
		var passwd = $("#passwd").val();
		if (userid.length == 0) {
			alert("userid 필수")
			$("#userid").focus();
			event.preventDefault();
		} else if (passed.length == 0) {
			alert("passwd 필수")
			$("#passwd").focus();
			event.preventDefault();
		}
		var userid1 = $("#userid").val();
		var passwd1 = $("#passwd").val()
		if (userid1==null) {
			alert("userid 필수")
			$("#userid").focus();
			event.preventDefault();
		} else if (passed1==null) {
			alert("passwd 필수")
			$("#passwd").focus();
			event.preventDefault();
		}
	});
});
</script>
<c:if test="${!empty mesg }">
	<script>
		alert('${mesg}');
	</script>
</c:if>
<div id="section">
	<h3>로그인</h3>
	<div id="content">
		<form action="login" method="get">
		<div class="Form">
			<input type="text" name="userid" placeholder="아이디를 입력해주세요"><br>
			<input type="text" name="passwd" placeholder="비밀번호를 입력해주세요"><br>
			</div>
			<div class="Btn">
				<input type="submit" value="로그인"><br>
				<input type="reset" value="취소">
			</div>
		</form>
	</div>

</div>