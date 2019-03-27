import java.servlet.*;
import javax.servlet.*;
import java.util.*;
import java.io.*;
public class servlet1{
	public void doGet(HttpServletResponse response, HttpServletRequest) throws ServletException,IOException{
		response.setIntHeader('Refresh',1);
		Calender c = new GregorianCalendar();
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		String CT = hour+":"+ minute +":"+ second +" ";
		PrintWriter out = response.getWriter();
		out.println(CT);
	}
}