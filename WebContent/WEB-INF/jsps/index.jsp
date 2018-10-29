<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Canvas In Html</title>
</head>
<body>
	<canvas id="canv" width="200" height="200"></canvas>
	<form method="post" action="">
		<input id="inp_img" name="img" type="hidden" value="" />
		<input  id ="bt_upload" type="submit" value="Upload" />
	</form>
	<script>
		var canvas = document.getElementById("canv");
		var context = canvas.getContext('2d');
		
		context.arc(100,100,50,0,2*Math.PI);
		context.lineWidth = 5;
		context.fillStyle = '#EE111';
		context.fill();
		context.strokeStyle = '#CC0000';
		context.stroke();
		
	</script>
</body>
</html>