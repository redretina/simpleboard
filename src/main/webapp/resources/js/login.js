var id = document.getElementById("id");
var password = document.getElementById("password");
var message = document.getElementById("message");

document.getElementById("loginBtn").onclick = function() {	
	if(id.value == "") {
		message.innerHTML = "Enter the ID";
		return;
	}
	
	if(password.value == "") {
		message.innerHTML = "Enter the password";
		return;
	}
	
	message.innerHTML = "Wait a second...";
	
	var httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange = () => {
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if(httpRequest.status === 200) {
				var text = httpRequest.response;
				if(text == "success") {
					document.getElementById("login_form").submit();
				} else if(text == "noId") {
					message.innerHTML = "Cannot Find ID";
					return;
				} else if(text == "withdraw"){
					message.innerHTML = "Withdrawn ID";
					return;
				} else if(text == "fail"){
					message.innerHTML = "Check ID or PW Again";
					return;
				}
			}
		}
	};
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex+1));
	httpRequest.open('POST', contextPath+"/loginCheck?id="+id.value+"&password="+password.value);
	httpRequest.responseType = "text";
	httpRequest.send();
};