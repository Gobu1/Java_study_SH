alert("Welcom");

//1 
// int num = 1;
var num=1;
// num='abc';
let num2='1';

console.log(num == num2);

for(var i=0; i<10; i++){
    console.log(i);
    count=1;
}

console.log('-----------------')
console.log(i)
console.log(count)
console.log('-----------------')

// let ar = [1, '2', 3.14, true];
let ar = ['4', 1, 3, '2'];
ar.push(5);
console.log(ar);
ar.unshift('9');
ar.sort//오름차순
console.log(ar)
ar.reverse//내림차순
console.log(ar)
ar.forEach(function(v,i,ar){
    console.log("v : ", v);//
    console.log("i : ", i)
    console.log("ar : ", ar)
    console.log('---------------')
})  