<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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

</head>
<body>
  <body>

	<form method = "GET" action="\BuildCollage" >
		<div id="inputStuff">
			<input type="text" name="topic" placeholder="Enter topic" onkeydown="enterInput('CollageDisplay.jsp')">
			<input type="text" name="shape" placeholder="Enter shape"><br>
			Collage Options <select name = "options"></select><br>
  			<button name = "save"> Save to History</button></br>
			<input type="submit" value="Build Collage">
		</div>
	</form>



  </body>

</html>
