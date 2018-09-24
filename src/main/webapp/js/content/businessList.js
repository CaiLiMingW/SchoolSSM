function remove(id) {
    if(confirm("确定要删除该商户吗？")) {
        $("#mainForm").attr("action", $("#basePath").val() + "/businesses/" + id);
        $("#mainForm").submit();
    }
}

function search(currentPage) {
    $("#mainForm").attr("method","GET");
    $("#currentPage").val(currentPage);
    alert($("#currentPage").val())
	/*$("#mainForm").attr("action",$("#basePath").val() + "/businesses");*/ //GET提交 currentPage值提交后不修改
	location.href=$("#basePath").val()+"/businesses?pn="+currentPage;
}

function modifyInit(id) {
	location.href = $("#basePath").val() + "/businesses/" + id;
}