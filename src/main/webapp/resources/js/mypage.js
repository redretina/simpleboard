var hostIndex = location.href.indexOf(location.host) + location.host.length;
var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex+1));

document.getElementById("toModifyBtn").onclick = function() {
	location.href= contextPath+"/member_modify";
};

function withdraw() {
	if(confirm("Are you sure to withdraw?")) {
		location.href = contextPath+"/member_withdraw";
	}
}

function toAdmin() {
	location.href = contextPath+"/admin/main";
}