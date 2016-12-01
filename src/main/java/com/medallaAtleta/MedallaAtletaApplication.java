package com.medallaAtleta;

import com.medallaAtleta.Entity.Atleta;
import com.medallaAtleta.Service.AtletaService;
import com.medallaAtleta.Service.MedallaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MedallaAtletaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MedallaAtletaApplication.class, args);
		AtletaService atletaService = context.getBean(AtletaService.class);
		MedallaService medallaService = context.getBean(MedallaService.class);

		atletaService.registrarAtletas();
		medallaService.registrarMedallas();
	}
}
