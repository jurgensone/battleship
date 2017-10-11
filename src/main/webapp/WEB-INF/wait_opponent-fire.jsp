<%--
  Created by IntelliJ IDEA.
  User: inna.yurgensone
  Date: 10/11/2017
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Battleship</title>
    <meta http-equiv="refresh" content="3">
    <style>
        table.field td {
            width: 25px;
            height: 25px;
            border: 1px solid black;
        }
        table.field td.SHIP {
            background-color: black;
        }
        table.field td.MISS {
            background-color: aqua;
        }
        table.field td.HIT {
            background-color: red;
        }
    </style>
</head>
<body>
<table >
    <tr>
    <td>
<table class="field">
    <tr>
        <td></td>
        <c:forEach var="col" items="A,B,C,D,E,F,G,H,I,J">
            <td>${col}</td>
        </c:forEach>
    </tr>
    <c:forEach var="row" items="1,2,3,4,5,6,7,8,9,10">
        <tr>
            <td>${row}</td>
            <c:forEach var="col" items="A,B,C,D,E,F,G,H,I,J">
                <c:set var="addr" value="${col}${row}"/>
                <td class="${playerManager.player.myField.content[addr]}">
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
    </td>
    <td>
        <table class="field">
            <tr>
                <td></td>
                <c:forEach var="col" items="A,B,C,D,E,F,G,H,I,J">
                    <td>${col}</td>
                </c:forEach>
            </tr>
            <c:forEach var="row" items="1,2,3,4,5,6,7,8,9,10">
                <tr>
                    <td>${row}</td>
                    <c:forEach var="col" items="A,B,C,D,E,F,G,H,I,J">
                        <c:set var="addr" value="${col}${row}"/>
                        <td class="${playerManager.player.opponentField.content[addr]}">
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>

    </td>
    </tr>
</table>
</body>
</html>
