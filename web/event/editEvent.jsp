<%-- 
    Document   : addEvent
    Created on : Nov 22, 2013, 11:08:21 AM
    Author     : Akip Maulana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Event</title>
        <link rel="stylesheet" type="text/css" href="css/jquery.ui.all.css" />
        <link rel="stylesheet" type="text/css" href="css/demos.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery.ui.datepicker.css" />

        <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
        <script type="text/javascript" src="js/ui/jquery.ui.core.js"></script>
        <script type="text/javascript" src="js/ui/jquery.ui.datepicker.js"></script>
        <script type="text/javascript" src="js/ui/i18n/jquery.ui.datepicker-id.js"></script>
 
        <!--Jquery untuk datepicker-->
        <script type="text/javascript">
            $(document).ready(function(){
                $("#tanggal").datepicker({
                    showOn: "both", buttonImage: "css/images/calendar.png", buttonImageOnly: true, nextText: "", prevText: "", changeMonth: true, changeYear: true, dateFormat: "dd/mm/yy"
                });
                
                $("#tanggal_end").datepicker({
                    showOn: "both", buttonImage: "css/images/calendar.png", buttonImageOnly: true, nextText: "", prevText: "", changeMonth: true, changeYear: true, dateFormat: "dd/mm/yy"
                });
            });
        </script>
        <script type="text/javascript">
            function validasi(){
                var name_event=document.forms["formevent"]["name_event"].value;
                var begin=document.forms["formevent"]["begin"].value;
                var end=document.forms["formevent"]["end"].value;
                var quota=document.forms["formevent"]["quota"].value;
                var desc=document.forms["formevent"]["desc"].value;
                if (name_event===null || name_event==="")
                {
                    alert("Name Event must be filled out");
                    return false;
                }
                if (begin===null || begin===""){
                    alert("Start date must be filled out");
                    return false;
                }
                if (end===null || end===""){
                    alert("Finish date must be filled out");
                    return false;
                }
                if (quota===null || quota===""){
                    alert("Quota must be filled out");
                    return false;
                }
                if (desc===null || desc===""){
                    alert("Desc must be filled out");
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <% 
            model.Events_model event;
            int event_id;
            String name="";
            String begin="";
            String end="";
            String desc=""; 
            int quota =0;
            event= model.Events_model.class.cast(request.getAttribute("event"));
            event_id = event.getId_event();
            name = event.getNama_event();
            begin = event.getTgl_dimulai();
            end = event.getTgl_diselesi();
            desc = event.getDeskripsi();
            quota = event.getJml_peserta();
        %>
        <header><h1>Form Event</h1></header>
        <section>
            <form action="Events_ctrl?action=update&event_id=<%= event_id %>" method="post" onsubmit="return validasi();" name="formevent">
                <table>
                    <tr>
                        <td>Nama Event</td>
                        <td>:</td>
                        <td><input type="text" name="name_event" value="<%= name %>"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Tanggal Mulai</td>
                        <td>:</td>
                        <td>
                            <input type="text" id="tanggal" name="begin" value="<%= begin %>"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Tanggal Akhir</td>
                        <td>:</td>
                        <td>
                            <input type="text" id="tanggal_end" name="end" value="<%= end %>"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Quota</td>
                        <td>:</td>
                        <td>
                            <input type="number" name="quota" id="q" value="<%= quota %>"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>:</td>
                        <td><textarea cols="20" rows="5" name="desc"><%= desc %></textarea></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit"/></td>
                        <td> </td>
                        <td><input type="reset" value="Reset"/></td>
                        <td></td>
                    </tr>
                </table>
            </form>
        </section>
    </body>
</html>
