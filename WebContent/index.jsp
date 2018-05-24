<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function () {
		$.ajax({
			type: "get",
			url: "/Hello/first",
			success: function(response){
				var results = JSON.parse(response);
				console.log(results);
			},
			error: function(){
				console.log("error");
			}
		});
	});
</script>

</body>
</html>