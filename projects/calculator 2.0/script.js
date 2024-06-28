let sumEl = document.getElementById("sum-el");

function getNumbers() {
    let num1 = parseFloat(document.getElementById("num1-el").value);
    let num2 = parseFloat(document.getElementById("num2-el").value);
    return { num1, num2 };
}

function add(){
    let { num1, num2 } = getNumbers();
    let result = num1 + num2;
    sumEl.textContent = "Sum: " + result;
}

function subtract(){
    let { num1, num2 } = getNumbers();
    let result = num1 - num2;
    sumEl.textContent = "Sum: " + result;
}

function divide(){
    let { num1, num2 } = getNumbers();
    let result = num1 / num2;
    sumEl.textContent = "Sum: " + result;
}
 
function multiply(){
    let { num1, num2 } = getNumbers();
    let result = num1 * num2;
    sumEl.textContent = "Sum: " + result;
}
