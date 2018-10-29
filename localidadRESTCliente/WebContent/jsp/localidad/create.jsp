<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create localidad</title>
</head>
<body>

<form action="controller" method="post">    
                            
  <table>
             <tbody>
                <tr>
                  <td>Nombre</td>
                  <td><input type="text" name="nombre"></td>
               </tr>
              <tr>
                  <td>Longitud</td>
                  <td>
                  <input type="text" name="longitud"></td>
               </tr>
               <tr>
                  <td>Latitud</td>
                  <td>
                  <input type="text" name="latitud"></td>
               </tr>
               <tr>
                  <td>Activo</td>
                  <td>
                  <input type="text" name="activo"></td>
               </tr>
                                                                   
    </tbody>                                
  </table>
  	
     <input type="submit"><br>
     <input type="reset">  
     <input type="hidden" name="event" value="create">
</form>

     <a href="controller?event=index">Índice</a>



</body>
</html>