const commentAdd = document.querySelector("#commentAdd");
const commentList = document.querySelector("#commentList");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const more = document.querySelector("#more")

//페이지 변수
let page=1;
const bn = commentAdd.getAttribute("data-bookNum");
getCommentList(page, bn);

commentAdd.addEventListener("click", function(){
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
                // let  t = commentList.children;
                // if(t.length != 0){
                //     commentList.children[0].remove();
                // }
                for(let i=0; i<commentList.children.length;){
                    commentList.children[0].remove();
                }
                page=1;
                getCommentList(page, bn);
            }
        }
        
    }
    


})//click 이벤트 끝

function getCommentList(page, bn){
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "./commentList?Page="+page+"&bookNum="+bn);

    //GET의경우 enctype 불필요

    xhttp.send();

    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200){
            //1. jsp 사용환 결과물
            // commentList.innerHTML=xhttp.responseText;
            
            //2. json 결과물
            let result = JSON.parse(xhttp.responseText.trim());
            // let result = document.createElement("table");
            // let resultAr = document.createAttribute("class");
            // resultAr.value="table";
            // result.setAttributeNode(resultAr); 
            let pager = result.pager; //commentPager
            let ar = result.list;     //댓글리스트

            for(let i=0; i<ar.length; i++){
                let tr = document.createElement("tr");
                let td = document.createElement("td");
                tdtext = document.createTextNode(ar[i].contents);
                td.appendChild(tdtext);
                tr.appendChild(td);

                td = document.createElement("td");
                tdtext = document.createTextNode(ar[i].writer);
                td.appendChild(tdtext);
                tr.appendChild(td);

                td = document.createElement("td");


                tdtext = document.createTextNode(ar[i].regDate);
                td.appendChild(tdtext);
                tr.appendChild(td);

                td = document.createElement("td");
                tdtext = document.createTextNode("수정");
                let tdattr = document.createAttribute("class")
                tdattr.value = "update";
                td.setAttributeNode(tdattr);
                tdattr = document.createAttribute("data-contentsNum");
                tdattr.value=ar[i].num;
                td.setAttributeNode(tdattr);
                td.appendChild(tdtext);
                tr.appendChild(td);
                
                td = document.createElement("td");
                tdtext = document.createTextNode("삭제");
                tdattr = document.createAttribute("class")
                tdattr.value = "delete";
                td.setAttributeNode(tdattr);
                tdattr = document.createAttribute("data-contentsNum");
                tdattr.value=ar[i].num;
                td.setAttributeNode(tdattr);
                td.appendChild(tdtext);
                tr.appendChild(td);
                
                // result.appendChild(tr);
                commentList.append(tr);
                
                console.log(ar[i].writer);

                if(page >= pager.totalpage){
                    more.classList.add("disabled");
                }else{
                    more.classList.remove("disabled");
                }
                
            }
            console.log(commentList.childNodes);
            // commentList.children();
            // try {
                //     console.log(commentList.children());
                //     throw new Error("에러")
                // } catch (exception) {
                    
                    // }finally{
                        
                        // }
            console.log("----");
            

        }
    })

}
more.addEventListener("click", function(){
    page++; //
    getCommentList(page, bn);
})

commentList.addEventListener("click", function(event){
    // -----------update------------
    if(event.target.className=="update"){
        let contents = event.target.previousSibling.previousSibling.previousSibling.innerHTML;
        let writer = event.target.previousSibling.previousSibling.innerHTML;
        let num = event.target.getAttribute("data-contentsNum");
        document.querySelector("#updateContents").value=contents;
        document.querySelector("#updateWriter").value=writer;
        document.querySelector("#num").value=num;
        
        document.querySelector("#up").click();
    }
    // -----------delete-------------
    if(event.target.className=="delete"){
        let check = window.confirm("삭제 하시겠습니까?");
        if(check==true){
            let num = event.target.getAttribute("data-contentsNum");

            const xhttp = new XMLHttpRequest();
            console.log(num);

            xhttp.open("POST", "./commentDelete");

            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

            xhttp.send("num="+num);

            xhttp.onreadystatechange=function(){
                if(this.readyState==4 && this.status==200){
                    let result = xhttp.responseText.trim();
                    if(result==1){
                        alert("삭제 성공");
                        page=1;
                        for(let i=0; i<commentList.children.length;){
                            commentList.children[0].remove();
                        }
                        getCommentList(page, bn);
                    }else{
                        alert("삭제 실패")
                    }
                }
            }

        }else{

        }
    }

})

// -----modal update click----
const update = document.querySelector("#update");

update.addEventListener("click", function(){
    let num = document.getElementById("num").value;
    let contents = document.querySelector("#updateContents").value;

    
    const xhttp = new XMLHttpRequest();

    xhttp.open("POST", "./commentUpdate");

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.send("num="+num+"&contents="+contents);

    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200){
            let result = xhttp.responseText.trim();
            if(result==1){
                alert("업데이트 성공");
                for(let i=0; i<commentList.children.length;){
                    commentList.children[0].remove();
                }
                page=1;
                getCommentList(page, bn);
            }else{
                alert("업데이틋 실패")
            }
        }}
})