<%@page import = "java.io.*,java.util.*" %>
<%
   // Get session creation time.
   Date createTime = new Date(session.getCreationTime());
   
   // Get last access time of this Webpage.
   Date lastAccessTime = new Date(session.getLastAccessedTime());

   String title = "Welcome Back to my website";
   Integer hitsCount = (Integer)application.getAttribute("hitCounter");
   String userID = new String("Keerthu");
   //String userIDKey = new String(userID);
   

   // Check if this is new comer on your Webpage.
   if (session.isNew() ){
      title = "Welcome to my website";
      hitsCount = 1;
   }
   else{
        title = "Welcome Back";
        hitsCount = hitsCount + 1;
   }
   application.setAttribute("hitCounter",hitsCount);
   
%>

<html>
   <head>
      <title>Session Tracking</title>
   </head>
   
   <body>
      <center>
         <h1><%out.println(title);%></h1>
      </center>
      
      <table border = "1" align = "center"> 
         <tr bgcolor = "#949494">
            <th>Session info</th>
            <th>Value</th>
         </tr> 
         <tr>
            <td>id</td>
            <td><% out.print( session.getId()); %></td>
         </tr> 
         <tr>
            <td>Creation Time</td>
            <td><% out.print(createTime); %></td>
         </tr> 
         <tr>
            <td>Time of Last Access</td>
            <td><% out.print(lastAccessTime); %></td>
         </tr> 
         <tr>
            <td>User ID</td>
            <td><% out.print(userID); %></td>
         </tr> 
         <tr>
            <td>Number of visits</td>
            <td><% out.print(hitsCount); %></td>
         </tr> 
      </table> 
   
   </body>
</html>