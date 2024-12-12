package com.simpleboard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Post {
	private int num;
	private String writer;
	private String username;
	private String title;
	private String content;
	private int categoryNum;
	private String categoryName;
	private String regdate;
	private int readcount;
	private int state;
	private String stateName;
}
