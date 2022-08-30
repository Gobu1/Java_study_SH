console.log("dom_1");

let result = window.confirm("확인??");
console.log(result);

result = window.prompt("입력해라")
console.log(result);

let d1 = window.document.getElementById("d1");
window.alert(d1);
window.console.log(d1);
d1.innerText    ='<h1>'+result+'</h1>';

let d2 = document.getElementById("d2");
console.log(d2.innerHTML);
console.log(d2.innerText);

let d3 = document.getElementById("d3");
let d4 = document.getElementById("d4")
d4.innerHTML = d3.innerHTML;
