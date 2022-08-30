const d1 = document.getElementById("d1")
const d2 = document.getElementById("d2")
const d3 = document.getElementById("d3")
const btn1 = document.getElementById("btn1")
const btn2 = document.getElementById("btn2")
const btn3 = document.getElementById("btn3")


btn1.addEventListener ("click",function(){
    console.log ("asddas");
    console.log (d1.value);
    console.log (d1.value+d2.value)
    d3.value=d1.value/1+d2.value/1;

})

btn2.addEventListener("click", function(){
    alert("btn2")
})

btn3.addEventListener("click", function(){
    btn2.click
})