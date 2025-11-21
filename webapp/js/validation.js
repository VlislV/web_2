"use strict";
let x_btns = document.querySelectorAll('input[name="x_value"]');
let rInput = document.forms.form_xyr.elements.r_value;
let yInput = document.forms.form_xyr.elements.y_value;
let prevbtn = x_btns[0];
let form = document.getElementById("form_xyr");
let point = document.getElementById("point");



function setX(button) {
    if (prevbtn) {
        prevbtn.checked = false;
    }
    button.checked = true;
    prevbtn = button;
}

function validateForm(event) {
    event.preventDefault();
    let x;
    x_btns.forEach(x_btn => (x_btn.checked ? x = x_btn.value : null));

    if (!validateY(yInput)) {
       return false;
    }
    if (!validateR(rInput)) {
        return false;
    }
    form.submit();
}

function validateY(yInput) {
    const value = yInput.value.trim().replace(',', '.');
    if (value === "") {
        showError(yInput, "Введите значение Y");
        return false;
    }
    const numValue = Number(value);
    if (isNaN(numValue)) {
        showError(yInput, "Y должен быть числом");
        return false;
    }
    if (numValue <= -5 || numValue >= 3) {
        showError(yInput, "Y должен быть в диапазоне (-5, 3)");
        return false;
    }
    clearError(yInput);
    return true;
}

function validateR(rInput) {
    const value = rInput.value.trim().replace(',', '.');
    if (value === "") {
        showError(rInput, "Введите значение R");
        return false;
    }
    const numValue = Number(value);
    if (isNaN(numValue)) {
        showError(rInput, "R должен быть числом");
        return false;
    }
    if (numValue <= 2 || numValue >= 5) {
        showError(rInput, "R должен быть в диапазоне (2, 5)");
        return false;
    }
    clearError(rInput);
    return true;
}

function showError(input, message) {
    input.setCustomValidity(message);
    input.reportValidity();
}

function clearError(input) {
    input.setCustomValidity("");
    input.reportValidity();
}

function setPoint(event){
    if(validateR(rInput)){
    if (point) {
            point.setAttribute("cx", event.offsetX);
            point.setAttribute("cy", event.offsetY);
            point.setAttribute("visibility", "visible");
        }
        let pcost = 100 / rInput.value;
        let x = (event.offsetX - 150) / 100 * rInput.value;
        let y = (150 - event.offsetY) / 100 * rInput.value;
        let validX = [-3, -2, -1, 0, 1, 2, 3, 4, 5];
        let closestX = validX.reduce((prev, curr) => {
            return Math.abs(curr - x) < Math.abs(prev - x) ? curr : prev;
        });
        console.log(x, y);
        console.log("closest X:", closestX, "Y:", y.toFixed(10));
        let targetInput = document.querySelector(`input[name="x_value"][value="${closestX}"]`);
        if (targetInput) {
            setX(targetInput);
        }
        yInput.value = y.toFixed(10);
        form.submit();
    }
}

document.addEventListener("DOMContentLoaded", function() {
    x_btns.forEach(x_btn => x_btn.addEventListener("click", () => setX(x_btn)));
    let figure = document.getElementById("fig");
    figure.addEventListener("click", setPoint);
    yInput.addEventListener("input", () => clearError(yInput));
    rInput.addEventListener("input", () => clearError(rInput));
    form.addEventListener("submit", validateForm);
});