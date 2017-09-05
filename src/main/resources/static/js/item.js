$(document).ready(function() {

    $(".copy").click(function () {

        var id = this.title;
        $("#modal-message-header").html("核销成功:");
        $("#modal-message-body").html("券号：" + id);
        $("#modal-message").modal('show');
        var param = {};
        param.id = id;
        $.ajax({
            method: "POST",
            url: "/coupon/use/",
            data: JSON.stringify(param),
            contentType : 'application/json'
        }).done(function (response) {
            console.log(response);
            $("#modal-message").modal('show');
        });
        return false;
    });

    $("#refresh").click(function(){
        window.location.reload();
        return false;
    });
});