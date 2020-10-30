package com.logo.pruebalatam.back.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Poet implements Serializable{

	private static final long serialVersionUID = 6272651171452324299L;

	private String name;
	private String url;
	
}
