$(function() {
	common.showMessage($("#message").val());
});

function search(currentPage) {
    	if(currentPage ==0){
			return;
		}
	    $("#currentPage").val(currentPage);
    	/*alert($("#currentPage").val())*/
		alert($("#currentPage").val());
    	location.href=$("#basePath").val()+"/ad/search/?pn="+currentPage;
}

function remove(id) {
	if(confirm("确定要删除这条广告吗？")) {
		$("#id").val(id);
		$("#mainForm").attr("action",$("#basePath").val() + "/ad/remove");
		$("#mainForm").submit();
	}
}

function modifyInit(id) {
	$("#id").val(id);
	$("#mainForm").attr("action",$("#basePath").val() + "/ad/modifyInit");
	$("#mainForm").submit();
}