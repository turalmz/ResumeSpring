<%-- 
    Document   : users
    Created on : Feb 7, 2019, 6:41:00 PM
    Author     : TURAL
--%>

<%@page import="com.company.entity.User"%>

<%@page import="com.company.dao.inter.UserDaoInter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../static/css/style.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="../static/js/script.js"></script>

        <title>JSP Page</title>
    </head>
    <%

        User user = userDao.getById(1);


    %>
    <body>
        <h1>Hello World!</h1>
        <form action="UserController" method="post">

            <input type="hidden"  name="id" value="<%=user.getId()%>">
            <div>
                <lablel for="name" >Name:</lablel>
                <input type="text" name="name" value="<%=user.getFirstname()%>">
            </div>
            <br/>
            <div>
                <lablel for="surname" >Surname:</lablel>
                <input type="text" name="surname" value="<%=user.getLastname()%>">
            </div>
            <div>
                <input type="submit" value="Save">
            </div>
        </form>

        <!-- Tab links -->
        <div class="tab">
            <button class="tablinks" onclick="openCity(event, 'Profile')">Profile</button>

            <button class="tablinks" onclick="openCity(event, 'Detail')">Detail</button>
            <button class="tablinks" onclick="openCity(event, 'Skill')">Skill</button>
            <button class="tablinks" onclick="openCity(event, 'Emp_History')">Emp History</button>
        </div>

        <!-- Tab content -->
        <div id="Profile" class="tabcontent">
            <h3>Profile</h3>
            <form>
                <div>
                    <textarea name></textarea>

                    <input type="submit" value="Save">
                </div>
            </form>
        </div>

        <div id="Detail" class="tabcontent">
            <div>
                <h3>Detail</h3>
            </div>
            <div>
                <lablel for="address" >Address:</lablel>>
                <input type="text" name="address">
            </div>
            <br/>
            <div>
                <lablel for="phone" >Phone:</lablel>>

                <input type="text" name="phone">
            </div>

            <br/>
            <div>
                <lablel for="email" >Email:</lablel>>

                <input type="text" name="email">
            </div>

            <div>
                <lablel for="birthday" >Birthday:</lablel>>

                <input type="text" name="birthday">
            </div>

            <div>
                <lablel for="country" >Country:</lablel>>

                <!--                <input type="text" name="country">-->
                <select name="country">
                    <option value="A">A</option>
                </select>
            </div>

            <div>
                <lablel for="nationality" >Nationality</lablel>>

                <input type="text" name="nationality">
            </div>
            <div>
                <!--<input type="submit" value="Save">-->
                <select name="country">
                    <option value="A">A</option>
                </select>
            </div>
        </div>

        <div id="Skill" class="tabcontent">
            <h3>Skill</h3>
            <p>Paris is the capital of France.</p> 
        </div>

        <div id="Emp_History" class="tabcontent">
            <h3>Emp History</h3>
            <p>Tokyo is the capital of Japan.</p>
        </div>


    </body>
</html>
