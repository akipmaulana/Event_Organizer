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
                model.Events_model events= model.Events_model.class.cast(request.getAttribute("events"));
        %>
        <center>
                <header><h1>Daftar Acara</h1></header><br/>
                <a href="event/addEvent.jsp">Add Event</a><br><br>
                <table border="2">
                    <thead style="background: cornflowerblue">
                        <td>No</td>
                        <td>Event id</td>
                        <td>Nama Event</td>
                        <td>Start Date</td>
                        <td>Finish Date</td>
                        <td>Deskripsi</td>
                        <td>Quota</td>
                        <td>PJ</td>
                        <td>Operasi</td>
                    </thead>
                    <tbody>
                        <%
                                int no=1;
                                while(events.getData().next()){
                        //            atau dengan cara ini
                                    out.print("<tr>");
                                    out.print("<td>"+(no++)+"</td>");
                                    out.print("<td>"+events.getData().getString("event_id")+"</td>");
                                    out.print("<td>"+events.getData().getString("name")+"</td>");
                                    out.print("<td>"+events.getData().getString("begin")+"</td>");
                                    out.print("<td>"+events.getData().getString("end")+"</td>");
                                    out.print("<td>"+events.getData().getString("description")+"</td>");
                                    out.print("<td>"+events.getData().getString("quota")+"</td>");
                                    out.print("<td>"+events.getData().getString("user_id")+"</td>");
                                    out.print("<td>"
                                                + "<a href='Events_ctrl?action=del&id="+events.getData().getString("event_id")+"'>Delete</a>"
                                                + "<a href='Events_ctrl?action=edit&id="+events.getData().getString("event_id")+"'>Edit</a>"
                                            + "</td>");
                                    out.print("</tr>");
                                }
                        %>
                    </tbody>
                </table>    
            </center>    
    </body>
</html>
