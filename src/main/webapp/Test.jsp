<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"
    
    import = "java.util.List"
   
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
		Liste des dossiers de Test
		<%
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) request.getAttribute("Message");
		for (String s : list)
		{
			out.println(s);
		}
		%>
	</p>
		
</body>
</html>