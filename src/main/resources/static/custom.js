$("#bbswrite").on("click",function (){
    window.location.href ="/bbs";
})

jQuery.fn.serializeObject = function () {
    var obj = null;
    try {
        if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
            var arr = this.serializeArray();
            if (arr) {
                obj = {};
                jQuery.each(arr, function () {
                    obj[this.name] = this.value;
                });
            }
        }
    } catch (e) {
        alert(e.message);
    } finally {
    }
    return obj;
}

//작성 버튼 누르면 내용 다 가지고 ajax로 컨트롤러로 가
$("#save").on("click",function (){
    var id = $("#id").val();
    var title = $("#title").val();
    var context = $("#context").val();

    if(id == null || id ==""){
        alert("작성자를 입력해주세요")
    }
    if(title == null || title ==""){
        alert("제목을 입력해주세요")
    }
    if(context == null || context ==""){
        alert("내용을 입력해주세요")
    }

    var data = $("#bbs_form").serializeObject();

    console.log(data);

    $.ajax({
        type : "post",
        url  : "/bbsSave",
        data : JSON.stringify(data),
        contentType: 'application/json;charset=UTF-8',
        dataType: 'text',
        success : function (data) {
            alert(data);
            location.href = "/";
        }
    }).fail(function (r) {
        var message = JSON.parse(r.responseText);
        alert('서버 오류');
    })

})