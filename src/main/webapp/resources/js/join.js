var message = document.getElementById("message");
var id = document.getElementById("id");
var password = document.getElementById("password");
var name = document.getElementById("name");
var username = document.getElementById("username");
var phone = document.getElementById("phone");
var phone1 = document.getElementById("phone1");
var phone2 = document.getElementById("phone2");
var phone3 = document.getElementById("phone3");
var email = document.getElementById("email");

document.getElementById("joinSubmit").onclick = function() {
	if(id.value == "") {
		message.innerHTML = "Enter the ID";
		return;
	}
	
	var idReg = /[a-z0-9]{6,18}/g;
	if(!idReg.test(id.value)) {
		message.innerHTML = "ID must be 6~18 characters containing lowercase letters or numbers";
		return;
	}
	
	if(password.value == "") {
		message.innerHTML = "Enter the password";
		return;
	}
	
	var pwReg = /[a-zA-Z0-9!@#$%^&*()_+<>?{}]{8,20}/g;
	if(!pwReg.test(password.value)) {
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
	
	message.innerHTML = "Wait a second...";
	
	var httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange = () => {
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if(httpRequest.status === 200) {
				var text = httpRequest.response;
				if(text == "success") {
					document.getElementById("join_form").submit();
				} else if(text == "idExist"){
					message.innerHTML = "ID is already been used";
				} else if(text == "usernameExist"){
					message.innerHTML = "Username is already been used";
				}
			}
		}
	};
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex+1));
	httpRequest.open('POST', contextPath+"/joinCheck?id="+id.value+"&username="+username.value);
	httpRequest.responseType = "text";
	httpRequest.send();
};