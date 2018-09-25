<%-- 
    Document   : test
    Created on : Jul 23, 2018, 10:47:02 AM
    Author     : osmanForhad
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:url var="url_jqlib" value="/static/js/jquery-3.3.1.min.js" />
        <script src="${url_jqlib}"></script>
        <script>
            $(document).ready(function() {
    //alert('JQuery is ready and intrigrated');
    $("#id_get_time").click(function() {
    //alert('Button clicked...');
    $.ajax({
        url: "get_time",
        success: function (data) {
                        $("#id_time").html(data);
                    }
    });
});
});
        </script>
    </head>
    <body>
        <h1>AJAX Test Page</h1>
        <button id="id_get_time">Get server time</button> <br/>
        <p id="id_time"></p>
    </body>
</html>
