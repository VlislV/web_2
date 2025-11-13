<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="beans.StriksBean" %>
<%@ page import="beans.Point" %>
<%@ page import="java.util.LinkedList" %>
<table id="table" cellspacing="0" border="1">
    <thead>
        <tr>
            <th>X</th>
            <th>Y</th>
            <th>R</th>
            <th>Результат</th>
        </tr>
    </thead>
    <tbody>
        <jsp:useBean id="striksBean" class="beans.StriksBean" scope="session"/>
         <c:forEach var="el" items="${striksBean.contents}">
            <tr class="table-row">
                <td>${el.x}</td>
                <td>${el.y}</td>
                <td>${el.r}</td>
                <td>${el.result}</td>
            </tr>
         </c:forEach>
    </tbody>
</table>