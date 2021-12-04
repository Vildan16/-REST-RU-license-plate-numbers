package com.inovus.numbers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	List<Number> initBase = new ArrayList<>();

	@Bean
	CommandLineRunner InitDatabase(NumberRepository numberRepository) {
		char[] availableLetters = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		char[] digits = {'0', '0', '0'};
		char[] letters = {'А', 'А', 'А'};
		numberRepository.save(new Number(letters, digits));
		while (!String.copyValueOf(letters).equals("ХХХ")) {
			if (letters[2] != 'Х') {
				letters[2] = availableLetters[i1++];
			}
			else if (letters[1] != 'Х') {
				letters[2] = 'А';
				i1 = 1;
				letters[1] = availableLetters[i2++];
			}
			else {
				letters[2] = 'А';
				letters[1] = 'А';
				i1 = 1;
				i2 = 1;
				letters[0] = availableLetters[i3++];
			}

			while (!String.copyValueOf(digits).equals("999")) {
				if (digits[2] != '9')
					digits[2]++;
				else if (digits[1] != '9') {
					digits[2] = '0';
					digits[1]++;
				} else {
					digits[2] = '0';
					digits[1] = '0';
					digits[0]++;
				}
				initBase.add(new Number(letters, digits));
			}
		}
		numberRepository.saveAll(initBase);
		return args -> log.info("DataBase created.");
	}
}
