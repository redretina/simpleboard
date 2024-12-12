var categoryModifyForm = document.getElementById("categoryModifyForm");
var categoryModifyContent = document.getElementById("categoryModifyContent");
var categoryModifyNum = document.getElementById("categoryModifyNum");
var categoryAddContent = document.getElementById("categoryAddContent");

var modifyingCategory = '';

var hostIndex = location.href.indexOf(location.host) + location.host.length;
var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex+1));

function categoryEdit(num) {
	if(modifyingCategory != '') {
		document.getElementById("categoryContent"+modifyingCategory).style.display = "";
	}
	document.getElementById("newCategoryContent").style.display = "";
	categoryAddForm.style.display = "none";
	categoryModifyContent.value = document.getElementById("realCategoryContent"+num).getHTML();
	categoryModifyNum.value = num;
	document.getElementById("categoryContent"+num).style.display = "none";
	document.getElementById("categoryContentArea"+num).append(categoryModifyForm);
	categoryModifyForm.style.display = "";
	modifyingCategory = num;
}

document.getElementById("categoryModifySubmitBtn").onclick = function() {
	if(categoryModifyContent.value == "") {
		alert("Enter the category name");
		return;
	}
	
	var httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange = () => {
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if(httpRequest.status === 200) {
				var text = httpRequest.response;
				if(text == "success") {
					var categoryModifyConfirm = confirm("Are you sure to modify this category?");
					if(categoryModifyConfirm == true) {
						categoryModifyForm.submit();
					} else {
						return;
					}
				} else if(text == "categoryExist"){
					alert("Category is already Exist");
				}
			}
		}
	};
	httpRequest.open('POST', contextPath+"/admin/categoryCheck?name="+categoryAddContent.value);
	httpRequest.responseType = "text";
	httpRequest.send();
}

document.getElementById("categoryModifyCancelBtn").onclick = function() {
	categoryModifyForm.style.display = "none";
	document.getElementById("categoryContent"+modifyingCategory).style.display = "";
}

document.getElementById("newCategoryBtn").onclick = function() {
	if(modifyingCategory != '') {
		document.getElementById("categoryContent"+modifyingCategory).style.display = "";
	}
	categoryModifyForm.style.display = "none";
	document.getElementById("newCategoryContent").style.display = "none";
	categoryAddForm.style.display = "";
}

document.getElementById("categoryAddSubmitBtn").onclick = function() {
	if(categoryAddContent.value == "") {
		alert("Enter the category name");
		return;
	}
	
	var httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange = () => {
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if(httpRequest.status === 200) {
				var text = httpRequest.response;
				if(text == "success") {
					var categoryAddConfirm = confirm("Are you sure to add this category?");
					if(categoryAddConfirm == true) {
						categoryAddForm.submit();
					} else {
						return;
					}
				} else if(text == "categoryExist"){
					alert("Category is already Exist");
				}
			}
		}
	};
	httpRequest.open('POST', contextPath+"/admin/categoryCheck?name="+categoryAddContent.value);
	httpRequest.responseType = "text";
	httpRequest.send();
}

document.getElementById("categoryAddCancelBtn").onclick = function() {
	categoryAddForm.style.display = "none";
	document.getElementById("newCategoryContent").style.display = "";
}

function categoryDelete(num) {
	var deleteCategoryConfirm = confirm("Are you sure to delete this category?")
	if(deleteCategoryConfirm == true) {
		location.href = contextPath+"/admin/category_delete_action/"+num;
	} else {
		return;
	}
}