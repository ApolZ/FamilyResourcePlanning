$(document).ready(function() {

    $(".copy").click(function () {
        var state = this.getAttribute("data-coupon-state");
        var id = this.getAttribute("data-coupon-id");
        var param = {};
        param.id = id;
        if (state && "0"===state) {
            //已使用，再来一张
            $.ajax({
                method: "POST",
                url: "/coupon/createAs/",
                data: JSON.stringify(param),
                contentType : 'application/json'
            }).done(function (response) {
                console.log(response);
                $("#modal-message-header").html(response["title"]);
                $("#modal-message-body").html(response["body"]);
                $("#modal-message").modal('show');
            });
        } else {
            //未使用，立即核销
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
        }
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