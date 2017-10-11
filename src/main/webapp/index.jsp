<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome to Battleship!</h1>
<form method="post" action="<c:url value="/registration"/>">
    <label>Enter your name: </label>
    <input type="text" name="username">
    <button>Start</button>
</form>
</body>
</html>
