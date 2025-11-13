<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="beans.StriksBean" %>
<%@ page import="beans.Point" %>
<%@ page import="java.util.LinkedList" %>

<jsp:useBean id="striksBean" class="beans.StriksBean" scope="session"/>
         <c:forEach var="el" items="${striksBean.contents}">
            <circle r="3.0"
                cx=${el.x * 100 / el.r + 150}
                cy=${300 - (el.y * 100 / el.r + 150)}
                id="point"
                fill=${(el.result == "MISS" ? "red" : "green")}>
            </circle>
         </c:forEach>