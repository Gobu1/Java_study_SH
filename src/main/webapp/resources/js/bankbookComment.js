const commentAdd = document.querySelector("#commentAdd");
const commentList = document.querySelector("#commentList");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");

getCommentList();

commentAdd.addEventListener("click", function(){
    let bn = commentAdd.getAttribute("data-bookNum");
    let wt = writer.value;
    let ct = contents.value;


    // ====== ajax ======
    //1. xHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. method, URL 준비
    xhttp.open("POST", "./commentAdd");

    //3. 요청 header 정보 (Enctype)
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //4. 전송 (post일 경우 파라미터 추가)
    xhttp.send("bookNum="+bn+"&writer="+wt+"&contents="+ct);

    //5. 응답 처리
    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200){
            let result = xhttp.responseText;
            console.log(result);
            result = JSON.parse(result);
            console.log(result.result);

            if(result.result==1){
                alert("댓글 성공")
            }
        }
        
    }
    


})//click 이벤트 끝

function getCommentList(){
    const xhttp = new XMLHttpRequest();
    let bn = commentAdd.getAttribute("data-bookNum");
    xhttp.open("GET", "./commentList?Page=1&bookNum=1662103891620")

    //GET의경우 enctype 불필요

    xhttp.send();

    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200){
            console.log(xhttp.responseText);
            //1. jsp 사용환 결과물
            // commentList.innerHTML=xhttp.responseText;
            
            //2. json 결과물
            let ar = JSON.parse(xhttp.responseText.trim());
            let result = document.createElement("table");
            let resultAr = document.createAttribute("class");
            resultAr.value="table";
            result.setAttributeNode(resultAr); 
            for(let i=0; i<ar.length; i++){
                let tr = document.createElement("tr");
                let td = document.createElement("td");
                tdtext = document.createTextNode(ar[i].writer);
                td.appendChild(tdtext);
                tr.appendChild(td);

                td = document.createElement("td");
                tdtext = document.createTextNode(ar[i].contents);
                td.appendChild(tdtext);
                tr.appendChild(td);

                td = document.createElement("td");
                tdtext = document.createTextNode(ar[i].regDate);
                td.appendChild(tdtext);
                tr.appendChild(td);
                
                result.appendChild(tr);
            }

            commentList.append(result);

        }
    })

}
