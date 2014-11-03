<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    import = "ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans.Infraction"
    import = "java.util.ArrayList"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%		@SuppressWarnings("unchecked")
		ArrayList <Infraction> listInf =(ArrayList<Infraction>) request.getAttribute("infractions") ;
		for (Infraction inf : listInf)
		{
			String f = inf.afficher() +"</br>";
			out.println(f);
		}
%>

</body>
</html>