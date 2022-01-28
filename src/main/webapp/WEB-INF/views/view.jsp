<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$("#btnUpdate").click(function(){
		document.form1.action = "/studyInterface/update/${dto.idx}";
		document.form1.submit();
	});
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			document.form1.action="/studyInterface/delete/${dto.idx}"
			document.form1.submit();
		}
	});
});
</script>
</head>
<body>
<h2>메모 보기</h2>
<form method = "post" name = "form1">
<table border = "1" width = "500px">
	<tr>
		<td>번호</td>
		<td>${dto.idx}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input name = "writer" value = "${dto.writer}"></td>
	</tr>
	<tr>
		<td>메모</td>
	</tr>
</table>
</form>
</body>
</html>