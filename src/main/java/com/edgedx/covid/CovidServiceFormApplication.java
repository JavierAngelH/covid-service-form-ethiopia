package com.edgedx.covid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@SpringBootApplication
public class CovidServiceFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidServiceFormApplication.class, args);
	}

}
