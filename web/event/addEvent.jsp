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
        <title>Event</title>
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
        <header><h1>Form Event</h1></header>
        <section>
            <form action="#" method="post" onsubmit="return validasi();" name="formevent">
                <table>
                    <tr>
                        <td>Nama Event</td>
                        <td>:</td>
                        <td><input type="text" name="name_event" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Tanggal Mulai</td>
                        <td>:</td>
                        <td>
                            <input type="date" id="pass" name="begin" />
<!--                             <select name="tanggal_mulai">
					<option id="1" value="1">1</option>
					<option id="2" value="2">2</option>
					<option id="3" value="3">3</option>
					<option id="4" value="4">4</option>
                                        <option id="5" value="1">1</option>
					<option id="6" value="2">2</option>
					<option id="7" value="3">3</option>
					<option id="8" value="4">4</option>
                                        <option id="9" value="1">1</option>
					<option id="10" value="2">2</option>
					<option id="11" value="3">3</option>
					<option id="12" value="4">4</option>
                                        <option id="13" value="1">1</option>
					<option id="14" value="2">2</option>
					<option id="15" value="3">3</option>
					<option id="16" value="4">4</option>
                            </select>-->
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Tanggal Akhir</td>
                        <td>:</td>
                        <td>
                            <input type="date" id="repass" name="end" />
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Quota</td>
                        <td>:</td>
                        <td>
                            <input type="number" name="quota" id="q" />
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>:</td>
                        <td><textarea cols="20" rows="5" name="desc"></textarea></td>
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
