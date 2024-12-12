package com.simpleboard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Member {
	private String id;
	private String password;
	private String username;
	private String name;
	private String phone;
	private String email;
	private String regdate;
	private String lastlogin;
	private int state;
	private String statename;
	private int postCount;
	private int replyCount;
}
