function moveCategory(categoryNum) {
	document.getElementById("categoryNum").value = categoryNum;
	document.getElementById("category_form").submit();
}

function moveSearch() {
	document.getElementById("searchKeyword").value = document.getElementById("searchInput").value;
	document.getElementById("search_form").submit();
}