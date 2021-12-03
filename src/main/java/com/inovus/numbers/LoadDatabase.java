package com.inovus.numbers;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Configuration
class LoadDatabase {

	private static final Logger log = (Logger) LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	void InitDatabase(NumberRepository numberRepository) {
		List<Number> initBase = new ArrayList<>();
		char[] tmp = {'A', 'B', 'C'};
		initBase.add(new Number(tmp, 234));

		numberRepository.saveAll(initBase);
	}
}
