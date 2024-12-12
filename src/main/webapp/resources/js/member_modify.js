var hostIndex = location.href.indexOf(location.host) + location.host.length;
var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex+1));

var modifyForm = document.getElementById("modifyForm");
var message = document.getElementById("message");
var password = document.getElementById("password"); 
var username = document.getElementById("username");
var name = document.getElementById("name");
var phone1 = document.getElementById("phone1");
var phone2 = document.getElementById("phone2");
var phone3 = document.getElementById("phone3");
var email = document.getElementById("email");
var checkUsername = document.getElementById("checkUsername");


document.getElementById("modifySubmit").onclick = function() {
	var pwReg = /[a-zA-Z0-9!@#$%^&*()_+<>?{}]{8,20}/g;
	if(password.value != "" && !pwReg.test(password.value)) {
		message.innerHTML = "Password must be 8~20 characters containing alphabets, numbers, or special characters";
		return;
	}
	
	if(username.value == "") {
		message.innerHTML = "Enter your username to be shown to others";
		return;
	}
	
	if(name.value == "") {
		message.innerHTML = "Enter your name";
		return;
	}
	
	if(phone2.value == "" || phone3.value == "") {
		message.innerHTML = "Enter your phone number";
		return;
	}
	
	var phoneReg1 = /\d{3,4}/g;
	var phoneReg2 = /\d{4}/g;
	if(!phoneReg1.test(phone2.value)) {
		message.innerHTML = "Enter the right form of phone number (01X-XXX(X)-XXXX)";
		return;
	} else if(!phoneReg2.test(phone3.value)) {
		message.innerHTML = "Enter the right form of phone number (01X-XXX(X)-XXXX)";
		return;
	}
	
	phone.value = phone1.value+"-"+phone2.value+"-"+phone3.value;
	
	if(email.value == "") {
		message.innerHTML = "Enter your email address";
		return;
	}
	
	var emailReg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	if(!emailReg.test(email.value)) {
		message.innerHTML = "Enter the right form of email address";
		return;
	}
	
	var httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange = () => {
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if(httpRequest.status === 200) {
				var text = httpRequest.response;
				if(text == "success") {
					var modifyConfirm = confirm("Are you sure to modify your profile?");
					if(modifyConfirm == true) {
						modifyForm.submit();
					} else {
						return;
					}
				} else if(text == "usernameExist"){
					message.innerHTML = "Username is already been used";
					return;
				}
			}
		}
	};
	httpRequest.open('POST', contextPath+"/usernameCheck?username="+username.value+"&checkUsername="+checkUsername.value);
	httpRequest.responseType = "text";
	httpRequest.send();
};

document.getElementById("modifyCancel").onclick = function() {
	location.href = contextPath+"/mypage";
}