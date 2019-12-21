/**
 * 下拉选从字典表中取值
 * @param selectId select标签ID
 * @param dicType 字典类型
 */
function dicSelectVal(selectId, dicType) {
    $.ajax({
        url: '/system/dict/data/getDataByDictType/' + dicType.toString(),
        data: '',
        type: 'GET',
        async: false,
        processData: false,
        contentType: false,
        success: function (data) {
            success(data);
        },
        error: function () {
            window.location.href = "/error.html";
        }
    });

    function success(data) {
            if (selectId != '' &&
                (($('#' + selectId.toString()).val() == null) || ($('#' + selectId.toString()).val() == ''))) {
                $('#' + selectId.toString()).empty(); //清空原有下拉选数据
                var optionFirst = document.createElement("option");
                $(optionFirst).val("");
                $(optionFirst).text("--全部--");
                $('#' + selectId.toString()).append(optionFirst);
                for (var i = 0, length = data.length; i < length; i++) {
                    var option = document.createElement("option");
                    $(option).val(data[i].dictValue);
                    $(option).text(data[i].dictLabel);
                    $('#' + selectId.toString()).append(option);
                }
            }
            // 数据放置到sessionStorage中一份
            sessionStorage.setItem(dicType, JSON.stringify(data));
        }
}