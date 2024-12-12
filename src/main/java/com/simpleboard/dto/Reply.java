package com.simpleboard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Reply {
	private int num;
	private int postNum;
	private String postTitle;
	private String writer;
	private String username;
	private String content;
	private String regdate;
	private int state;
}
