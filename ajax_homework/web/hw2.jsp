<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 4/15/20
  Time: 11:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hw2</title>
    <script src="js/jquery-3.4.1.min.js"></script>
    <script>
        function btn() {
            var lat = document.getElementById("lat").value;
            var lon = document.getElementById("lon").value;
            $.ajax({
                "url" : "https://api.openweathermap.org/data/2.5/find?lat=" + lat + "&lon=" + lon +
                "&cnt=10&appid=43200fd7e56d516815238c4e9dae7713"
            }).then(function(data) {
                document.getElementById("container").innerHTML = "";
                console.log(data.list.length);
                for (var i = 0; i < data.list.length; i++) {
                    document.getElementById("container").innerHTML +=
                        "<h2>City " + (i + 1) + " : " + data.list[i]["name"] + "</h2><br />"
                }
            });
        }

    </script>
</head>
<body>
<input type="text" id="lat" placeholder="lat">
<input type="text" id="lon" placeholder="lon">
<input type="submit" id="button" onclick = "btn()"/>
<div id="container">Response comes here...</div>
</body></body>
</html>
