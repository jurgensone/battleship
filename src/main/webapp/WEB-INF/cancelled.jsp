<%--@elvariable id="playerManager" type="lv.ctco.battleship.model.PlayerManager"--%>
<%--
  Created by IntelliJ IDEA.
  User: inna.yurgensone
  Date: 10/17/2017
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session expired</title>
</head>
<body>
    <h2>Sorry, <c:out value="${playerManager.player.name}"/>!</h2>
    <h1>Your opponent cancelled the game!</h1>
</body>
</html>
