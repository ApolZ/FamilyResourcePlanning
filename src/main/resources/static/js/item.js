$(document).ready(function() {

    $(".copy").click(function () {
        var id = this.title;
        var param = {};
        param.id = id;
        $.ajax({
            method: "POST",
            url: "/coupon/use/",
            data: JSON.stringify(param),
            contentType : 'application/json'
        }).done(function (response) {
            console.log(response);
            $("#modal-message-header").html("核销成功:");
            $("#modal-message-body").html("券号：" + id);
            $("#modal-message").modal('show');
        });
        return false;
    });


    $("#save").click(function () {
        var param = {};
        param.name = $("#coupon-name").val();
        param.description = $("#coupon-description").val();
        param.ownerId = $("#coupon-owner").val();
        param.type = $("#coupon-type").val();
        $.ajax({
            method: "POST",
            url: "/coupon/create/",
            data: JSON.stringify(param),
            contentType : 'application/json'
        }).done(function (response) {
            console.log(response);
            $("#modal-message-header").html("新增成功");
            $("#modal-message-body").html("券号：" + id);
            $("#modal-message").modal('show');
        });
        return false;
    });

    /**
     * 模态框按键定义
     */
    $("#refresh").click(function(){
        window.location.reload();
        return false;
    });
    $("#view-0").click(function(){
        window.location = "/0/";
        return false;
    });
    $("#view-1").click(function(){
        window.location = "/1/";
        return false;
    });
});