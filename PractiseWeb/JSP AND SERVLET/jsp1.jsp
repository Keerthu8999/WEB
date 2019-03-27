<%@ page import = "java.io.*,java.util.*"%>
<html>
<body>
<%
	out.println("<table><tr>");
	String all = request.getHeaderNames();
	while(all.hasMoreElements()){
		String name = (String)all.nextElement();
		out.println("<th>"name"</th">);
		String value = request.getHeader(name);
		out.println("<th>"value"</th">);
	}
	out.println("</tr></table>")
%>
</body>
</html>