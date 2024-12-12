document.getElementById("submitBtn").onclick = function() {
	if(document.getElementById("title").value == "") {
		alert("Write the title.");
		return;
	}
	
	if(document.getElementById("content").value == "") {
		alert("Write the contents.");
		return;
	}
	
	<!-- document.getElementById("content").value = document.getElementById("realContent").getHTML(); -->
	
	document.getElementById("modify_form").submit();
};