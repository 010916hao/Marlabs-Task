<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 4/14/20
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>$Title$</title>
        <script src="js/jquery-3.4.1.min.js"></script>
        <script>
            function btn() {
                var zipCode = document.getElementById("zipCode").value;
                    $.ajax({
                        "url" : "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode +",us&appid=43200fd7e56d516815238c4e9dae7713"
                    }).then(function(data) {
                        document.getElementById("container").innerHTML = "<h2>Cityname : " + data.name +
                            "</h2><br /><h3>Temp_Min : " + data.main["temp_min"] + "</h3><br /><h3>Temp_max :"
                            + data.main["temp_max"] + "</h3>";

                    });
//                });
            }

        </script>
    </head>
    <body>
    <input type="text" id="zipCode">
    <input type="submit" id="button" onclick = "btn()"/>
    <div id="container">Response comes here...</div>
    </body>
</html>
