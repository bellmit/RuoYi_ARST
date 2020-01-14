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

/**
 * 获取Date的yyyy-mm-dd hh:mi:ss
 * @param Date
 * @returns {string}
 */
function formatYMDHMS(Date){
    var Y = Date.getFullYear();
    var M = Date.getMonth() + 1;
    M = M < 10 ? '0' + M : M;// 不够两位补充0
    var D = Date.getDate();
    D = D < 10 ? '0' + D : D;
    var H = Date.getHours();
    H = H < 10 ? '0' + H : H;
    var Mi = Date.getMinutes();
    Mi = Mi < 10 ? '0' + Mi : Mi;
    var S = Date.getSeconds();
    S = S < 10 ? '0' + S : S;
    return Y + '-' + M + '-' + D + ' ' + H + ':' + Mi + ':' + S;
}


/**
 * 根据页面下拉选转义为中文
 * @param selectId
 * @param value
 * @returns {string|*}
 */
function transDicValToName(selectId, value){
    let result = value;
    let queryPath = '#' + selectId + ' option';
    if (value === undefined || value === "" || value === null) {
        return "";
    } else {
        $(queryPath).each(function () {
            if ($(this).val().toString() === value.toString()) {
                result = $(this).text();
            }
        });
    }
    return result;
}