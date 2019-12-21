var prefix = ctx + "base/institutionsInfo"
$("#form-institutionsInfo-add").validate({
    focusCleanup: true
});
function submitHandler() {
    if ($.validate.form()) {
        $.operate.save(prefix + "/add", $('#form-institutionsInfo-add').serialize());
    }
}
dicSelectVal("instType", "instType");
$("#instType option[value='']").remove();