$(document).ready(function() {

    $(".check").click(function () {
        $("#modal-message-header").html("核销成功");
        $("#modal-message").modal('show');
    //     var code = $("#meta-code").val();
    //     if (!code || code.indexOf(" ") != -1 ) {
    //         $("#modal-message-header").html("创建失败：缺少code或code含有空格");
    //         $("#modal-message").modal('show');
    //         return false;
    //     }
    //     var title = $("#textarea-title").val();
    //     var description = $("#textarea-description").val();
    //     var keywords = $("#textarea-keywords").val();
    //     var annotation = $("#textarea-annotation").val();
    //     var param = {};
    //     param.title = title;
    //     param.description = description;
    //     param.keywords = keywords;
    //     param.annotation = annotation;
    //     param.code = code;
    //     $.ajax({
    //         method: "POST",
    //         url: window.basePath + "/protected/meta/update/",
    //         data: JSON.stringify(param),
    //         contentType : 'application/json'
    //     }).done(function (response) {
    //         if (response && response.status && response.status == "SUCCESS") {
    //             $("#modal-message-header").html("更新TDK记录成功");
    //         } else {
    //             $("#modal-message-header").html("更新TDK记录失败");
    //             $("#modal-message-body").html(response.message || "无ErrorMessage");
    //         }
    //         $("#modal-message").modal('show');
    //     });
    //     return false;
    });

});