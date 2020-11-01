package com.logo.pruebalatam.back.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Response implements Serializable{

	private static final long serialVersionUID = -198680720659131227L;
	
	private long diasParaCumpleanios;
	private Poem poems;
	private ServiceStatus serviceStatus;

}
