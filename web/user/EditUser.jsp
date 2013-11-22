<%-- 
    Document   : EditUser
    Created on : Nov 13, 2013, 8:46:04 AM
    Author     : Akip Maulana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User</title>
        <script type="text/javascript">
            function cek(){
		pas = document.getElementById("pass");
		rep = document.getElementById("repass");
		if(pas.value===rep.value){
			document.getElementById("hasilp").innerHTML = "match";
		}else{
			document.getElementById("hasilp").innerHTML = "not match";
		}
            }

            function validasi(){
                var username=document.forms["formUser"]["username"].value;
                var nohp=document.forms["formUser"]["hp"].value;
                var email=document.forms["formUser"]["email"].value;
                if (username===null || username==="")
                {
                    alert("Username must be filled out");
                    return false;
                }
                if (nohp===null || nohp===""){
                    alert("Phone Number must be filled out");
                    return false;
                }
                if (!document.getElementById("L").checked &&
                     !document.getElementById("P").checked ){
                    alert("Gender must be filled out");
                    return false;
                }
                if (email===null || email===""){
                    alert("Email must be filled out");
                    return false;
                }
                if(isNaN(idnum)){
                    alert("ID must be number");
                    return false;
                }
            }
        </script>
        <style>
            *{
                margin-left: 5%;
            }
        </style>
    </head>
    <body>
        <% 
            model.User user;
            String id_user;
            String username="";
            String password="";
            String jenis_kelamin="";
            String nomer_hp=""; 
            String email="";
            user= model.User.class.cast(request.getAttribute("identitas"));
            id_user = user.getId_user();
            username = user.getUsername();
            password = user.getPassword();
            jenis_kelamin = user.getJenis_kelamin();
            nomer_hp = user.getNomer_hp();
            email = user.getEmail();
        %>
        <header><h1>Edit</h1></header>
        <section>
            <form action="UserServlet?action=update&id=<%= id_user %>" method="post" onsubmit="return validasi();" name="formUser">
                <table>
                    <tr>
                        <td>Username</td>
                        <td>:</td>
                        <td><input type="text" name="username" value="<%= username %>"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>:</td>
                        <td><input type="password" id="pass" name="psword" value="<%= password %>" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Re-password</td>
                        <td>:</td>
                        <td><input type="password" id="repass" onkeyup="cek();" value="<%= password %>" /></td>
                        <td id="hasilp"></td>
                    </tr>
                    <tr>
                        <td>Jenis Kelamin</td>
                        <td>:</td>
                        <td>
                            <input type="radio" name="kl" id="L" value="L" />L<br>
                            <input type="radio" name="kl" id="P" value="P" />P
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Nomor Hp</td>
                        <td>:</td>
                        <td><input type="text" name="hp" value="<%= nomer_hp %>"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>:</td>
                        <td><input type="email" name="email" value="<%= email %>"/></td>
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
