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
            $("#modal-message-header").html(response["title"]);
            $("#modal-message-body").html(response["body"]);
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
            $("#modal-message-header").html(response["title"]);
            $("#modal-message-body").html(response["body"]);
            $("#modal-message").modal('show');
        });
        return false;
    });
});