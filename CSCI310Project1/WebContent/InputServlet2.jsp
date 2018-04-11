<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  	<style type="text/css">
 	body {
		background-color: #d3d3d3;
	}
	#inputBox {
		border-color: #a9a9a9;
	}
	#inputStuff {
		position: absolute;
	
	    width: 300px;
	    height: 300px;
	
	    /* Center form on page horizontally & vertically */
	    top: 50%;
	    left: 50%;
	    margin-top: -40px;
	    margin-left: -90px;
	}
	#inputButton {
		background-color: #a9a9a9;
		color: white;
	}
</style>
<script type="text/javascript">
 function openPage(pageURL)
 {
 	window.location.href = pageURL;
 }
</script>

<script type="text/javascript">

function enterInput(pageURL) {
	document.getElementById('inputBox').onkeypress = function(e) {
		var event = e || window.event;
	    var charCode = event.which || event.keyCode;
	
	    if ( charCode == '13' ) {
	      // Enter pressed    
	      window.location.href = pageURL;
	      return false;
	    }
	}
}
</script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method = "GET" action="BuildCollage" >
		<div id="inputStuff">
			<input type="text" name="topic" placeholder="Enter topic" onkeydown="enterInput('CollageDisplay.jsp')">
			<input type="submit" value="Build Collage">
		</div>
	</form>
</body>
</html>
