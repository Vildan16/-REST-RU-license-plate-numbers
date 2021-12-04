package com.inovus.numbers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
class NumberController {
	private final NumberRepository numberRepository;
	private Long currentId;

	NumberController(NumberRepository numberRepository) {
		this.numberRepository = numberRepository;
	}

	@GetMapping(path = "/number/random")
	List<Number> random() {
		return numberRepository.findAll();
	}
}
