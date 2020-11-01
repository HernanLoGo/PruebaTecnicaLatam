package com.logo.pruebalatam.back.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceStatus implements Serializable{

	private static final long serialVersionUID = -343141514760604485L;
	
	private int codigo;
	private String detalle;
	
}
