package com.logo.pruebalatam.back.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Poem implements Serializable{

	private static final long serialVersionUID = -8551063207117486490L;

	private String title;
	private String content;
	private String url;
	private Poet poet;
	
}
