
//1. 선택자 / 선택자.속성명, 선택자.어트리뷰트
const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d3 = document.getElementById("d3");
const year = document.getElementById("year")
const month = document.getElementById("month")
const date = document.getElementById("date")
const d4 = document.getElementById("d4")

alert(d1.value);
alert(d1.getAttribute("value"));
d2.type="button";
// d2.setAttribute("type", "button"); 두개 같은것

// let count = window.prompt("숫자를 입력하세요")
let t="";

// for (let i=0; i<count; i++){
//     t=t+'<input type="text">';
//     d3.innerHTML=t;
// }
for(let i=1990; i<2022; i++){
    t=t+'<option>'+i+'</option>'
    year.innerHTML=t;
}
t=0;
for(let i=1; i<13; i++){
    t=t+'<option>'+i+'</option>'
    month.innerHTML=t;
}
t=0;
for(let i=1; i<31; i++){
    t=t+'<option>'+i+'</option>'
    date.innerHTML=t;
}

t=0;
let r = prompt("row의 갯수 입력")
let c = prompt("coulmn의 객수 입력")

for(let i=1; i<=r; i++){
    t=t+"<tr>";
    for(let j=1; j<=c; j++ ){
        t=t+"<td>"+i+j;
        t=t+"</td>";
    }
    t=t+"</tr>";
}
d4.innerHTML=t;




