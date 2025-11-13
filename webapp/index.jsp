<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Web_lab1</title>
    <link rel="stylesheet" href="css/forms.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
    <header>
        <span>Горшенин Владислав Дмитриевич</span>
        <span>Группа: P3232</span>
        <span>Вариант: 32422</span>
    </header>

    <div class="content-wrapper">
        <figure id = "fig">
            <svg height="300" width="300" xmlns="http://www.w3.org/2000/svg">

                <line stroke="black" x1="0" x2="300" y1="150" y2="150"></line>
                <line stroke="black" x1="150" x2="150" y1="0" y2="300"></line>
                <polygon fill="black" points="150,0 144,15 156,15" stroke="black"></polygon>
                <polygon fill="black" points="300,150 285,156 285,144" stroke="black"></polygon>


                <line stroke="black" x1="200" x2="200" y1="155" y2="145"></line>
                <line stroke="black" x1="250" x2="250" y1="155" y2="145"></line>
                <line stroke="black" x1="50" x2="50" y1="155" y2="145"></line>
                <line stroke="black" x1="100" x2="100" y1="155" y2="145"></line>
                <line stroke="black" x1="145" x2="155" y1="100" y2="100"></line>
                <line stroke="black" x1="145" x2="155" y1="50" y2="50"></line>
                <line stroke="black" x1="145" x2="155" y1="200" y2="200"></line>
                <line stroke="black" x1="145" x2="155" y1="250" y2="250"></line>

                <text fill="black" x="195" y="140">R/2</text>
                <text fill="black" x="250" y="140">R</text>
                <text fill="black" x="40" y="140">-R</text>
                <text fill="black" x="85" y="140">-R/2</text>
                <text fill="black" x="160" y="55">R</text>
                <text fill="black" x="160" y="105">R/2</text>
                <text fill="black" x="160" y="204">-R/2</text>
                <text fill="black" x="160" y="255">-R</text>
                <text fill="black" x="285" y="140">X</text>
                <text fill="black" x="160" y="15">Y</text>

                <polygon fill="blue" fill-opacity="0.2" stroke="blue" points="100,150 150,150 150,250 100,250"></polygon>
                <polygon fill="blue" fill-opacity="0.2" stroke="blue" points="150,150 150,100 50,150"></polygon>
                <path fill="blue" fill-opacity="0.2" stroke="blue" d="M 200 150 C 200 200, 150 200, 150 200 L 150 150 Z"></path>

                <circle id="point" r="4" cx="150" cy="150" fill="black" stroke="white" visibility="hidden"/>
                <jsp:include page="jsp/points.jsp"/>
            </svg>
        </figure>

            <section class="form-block">
                <h2>Кальcoolятор точек</h2>
                <form name="form_xyr" id="form_xyr" action="api/AreaCheck" method="POST">
                    <div class="form-group">
                        <label class="form-label">Координата X точки:</label>
                        <div class="x-buttons">
                            <input type="radio" name="x_value" value="-3" id="x_-3" class="x-radio" checked>
                            <label for="x_-3" class="x-btn">-3</label>

                            <input type="radio" name="x_value" value="-2" id="x_-2" class="x-radio">
                            <label for="x_-2" class="x-btn">-2</label>

                            <input type="radio" name="x_value" value="-1" id="x_-1" class="x-radio">
                            <label for="x_-1" class="x-btn">-1</label>

                            <input type="radio" name="x_value" value="0" id="x_0" class="x-radio">
                            <label for="x_0" class="x-btn">0</label>

                            <input type="radio" name="x_value" value="1" id="x_1" class="x-radio">
                            <label for="x_1" class="x-btn">1</label>

                            <input type="radio" name="x_value" value="2" id="x_2" class="x-radio">
                            <label for="x_2" class="x-btn">2</label>

                            <input type="radio" name="x_value" value="3" id="x_3" class="x-radio">
                            <label for="x_3" class="x-btn">3</label>

                            <input type="radio" name="x_value" value="4" id="x_4" class="x-radio">
                            <label for="x_4" class="x-btn">4</label>

                            <input type="radio" name="x_value" value="5" id="x_5" class="x-radio">
                            <label for="x_5" class="x-btn">5</label>
                        </div>

                    </div>

                    <div class="form-group">
                        <label for="Y_value" class="form-label">Координата Y точки:</label>
                        <input type="text" id="Y_value" name="y_value" class="form-input"
                               placeholder="Введите число (-5; 3)" required maxlength="10">
                    </div>

                    <div class="form-group">
                        <label for="R_value" class="form-label">Радиус R:</label>
                        <input type="text" id="R_value" name="r_value" class="form-input"
                               placeholder="Введите число (2; 5)" required maxlength="10">
                    </div>

                    <div class="form-group">
                        <button type="submit" class="submit-btn">Рассчитать</button>
                        <button type="reset" class="reset-btn">Очистить</button>
                    </div>
                </form>
            </section>
    </div>
    <div id="alertHandler"></div>
    <jsp:include page="jsp/table.jsp"/>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="js/validation.js"></script>
</body>
</html>
