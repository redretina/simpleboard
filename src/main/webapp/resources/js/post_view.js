var replyContent = document.getElementById("replyContent");
var replyMessage = document.getElementById("replyMessage");
var replyForm = document.getElementById("replyForm");
var replyModifyForm = document.getElementById("replyModifyForm");
var replyModifyMessage = document.getElementById("replyModifyMessage");
var replyModifyContent = document.getElementById("replyModifyContent");
var replyModifyNum = document.getElementById("replyModifyNum");

var modifyingReply = '';

var hostIndex = location.href.indexOf(location.host) + location.host.length;
var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex+1));

document.getElementById("replySubmitBtn").onclick = function() {
	if(replyContent.value == "") {
		replyMessage.innerHTML = "Enter the comment";
		return;
	}
	
	replyForm.submit();
};

function modifyReply(num) {
	if(modifyingReply != '') {
		document.getElementById("replyContent"+modifyingReply).style.display = "";
	}
	replyModifyContent.value = document.getElementById("realReplyContent"+num).getHTML();
	replyModifyNum.value = num;
	document.getElementById("replyContent"+num).style.display = "none";
	document.getElementById("replyContentArea"+num).append(replyModifyForm);
	replyModifyForm.style.display = "";
	modifyingReply = num;
}

document.getElementById("replyModifySubmitBtn").onclick = function() {
	if(replyModifyContent.value == "") {
		replyModifyMessage.innerHTML = "Enter the comment";
		return;
	}
	var replyModifyConfirm = confirm("Are you sure to modify this comment?");
	if(replyModifyConfirm == true) {
		replyModifyForm.submit();
	} else {
		return;
	}
}

document.getElementById("replyModifyCancelBtn").onclick = function() {
	replyModifyForm.style.display = "none";
	document.getElementById("replyContent"+modifyingReply).style.display = "";
}

function deleteReply(num) {
	var deleteReplyConfirm = confirm("Are you sure to delete this comment?")
	if(deleteReplyConfirm == true) {
		location.href = contextPath+"/reply_delete_action/"+num;
	} else {
		return;
	}
}

function modifyPost(num) {
	location.href = contextPath+"/post_modify/"+num;
}

function deletePost(num) {
	var deletePostConfirm = confirm("Are you sure to delete this post?");
	if(deletePostConfirm == true) {
		location.href = contextPath+"/post_delete_action/"+num;
	} else {
		return;
	}
}