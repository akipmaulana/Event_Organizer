<%-- 
    Document   : ViewAllDataUser
    Created on : Nov 12, 2013, 9:44:55 PM
    Author     : Akip Maulana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data User</title>
    </head>
    <body>
        <%
                model.User user= model.User.class.cast(request.getAttribute("userlist"));
        %>
        <center>
                <header><h1>Data Karyawan</h1></header><br/>
                <a href="user/RegistrasiUser.jsp">Add User</a><br><br>
                <table border="2">
                    <thead style="background: cornflowerblue">
                        <td>No</td>
                        <td>Username</td>
                        <td>Password</td>
                        <td>Email</td>
                        <td>Nomer HP</td>
                        <td>Jenis Kelamin</td>
                        <td>Kehadiran</td>
                        <td>Operasi</td>
                    </thead>
                    <tbody>
                        <%
                                int no=1;
                                while(user.getRs().next()){
                        //            atau dengan cara ini
                                    out.print("<tr>");
                                    out.print("<td>"+(no++)+"</td>");
                                    out.print("<td>"+user.getRs().getString("username")+"</td>");
                                    out.print("<td>"+user.getRs().getString("password")+"</td>");
                                    out.print("<td>"+user.getRs().getString("email")+"</td>");
                                    out.print("<td>"+user.getRs().getString("nomer_hp")+"</td>");
                                    out.print("<td>"+user.getRs().getString("jenis_kelamin")+"</td>");
                                    out.print("<td>"+user.getRs().getString("kehadiran")+"</td>");
                                    out.print("<td>"
                                                + "<a href='UserServlet?action=del&id="+user.getRs().getString("id_user")+"'>Delete</a>"
                                                + "<a href='UserServlet?action=edit&id="+user.getRs().getString("id_user")+"'>Edit</a>"
                                            + "</td>");
                                    out.print("</tr>");
                                }
                        %>
                    </tbody>
                </table>    
            </center>    
    </body>
</html>
