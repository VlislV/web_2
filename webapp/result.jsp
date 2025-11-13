<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="beans.StriksBean" %>
<%@ page import="beans.Point" %>
<%@ page import="java.util.LinkedList" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Web_lab1</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
    <header>
        <span>Горшенин Владислав Дмитриевич</span>
        <span>Группа: P3232</span>
        <span>Вариант: 32422</span>
    </header>
    <jsp:include page="jsp/table.jsp"/>
    <br>
    <a href="index.jsp">НА ГЛАВНУЮ</a>
</body>
</html>