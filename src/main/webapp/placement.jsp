<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Battleship</title>
</head>
<body>
<h1>Hello, ${playerManager.player.name}!</h1>
<h2>Please set your ships</h2>
<c:if test="${errorNotEnough}">
    <h3>Not enough ships</h3>
</c:if>
<c:if test="${errorTooMany}">
    <h3>There are too many ships</h3>
</c:if>
<form method="post" action="<c:url value="/placement"/>">
    <table>
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
                    <td>
                        <input type="checkbox" name="cell" value="${addr}"
                        <c:if test="${playerManager.player.myField.content[addr] eq 'SHIP'}"> checked </c:if> >
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
    <button>Ready</button>
</form>
</body>
</html>
