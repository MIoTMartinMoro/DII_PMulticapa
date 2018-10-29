<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salida</title>
</head>
<body>
<%

	HttpSession sesion= request.getSession();   
	String mensaje= (String) sesion.getAttribute("mensaje");
	out.println(mensaje + "<br>");
	
%>
         

<a href="controller?event=index">Índice</a>
</body>
</html>