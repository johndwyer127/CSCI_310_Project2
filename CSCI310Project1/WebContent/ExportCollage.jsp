<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "collage.Picture" %>
    <%@ page import = "collage.Collage" %>
    
    <%
    System.out.println("in ExportCollage.jsp");
    Picture currentCollage = (Picture)request.getSession().getAttribute("collageImage");
    if (currentCollage != null) {
    		System.out.println("topic: " + currentCollage.getTopic());
    }
    String fileName = application.getRealPath("/") + "exportedCollage.png";
    System.out.println("fileName: " + fileName);
    currentCollage.writeImage(fileName, "png");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Export Collage</title>
</head>
<body>

</body>
</html>