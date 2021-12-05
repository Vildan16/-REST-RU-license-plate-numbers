package com.inovus.numbers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@RestController
class NumberController {
	private final NumberRepository numberRepository;
	private long currentId = 0L;
	private final List<Number> usedNumbers = new ArrayList<>();

	NumberController(NumberRepository numberRepository) {
		this.numberRepository = numberRepository;
	}

	@GetMapping(path = "/number/random", produces = "text/plain")
	String random() {
		Number number;
		long qty = numberRepository.count();

		while (true) {
			currentId = (int) (Math.random() * qty);
			number = numberRepository.getById(currentId);
			if (usedNumbers.size() == qty)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No more available numbers");
			else if (!usedNumbers.contains(number)){
				usedNumbers.add(number);
				break;
			}
		}
		return number.getNumber();
	}

	@GetMapping(path = "/number/next", produces = "text/plain")
	String next() {
		return numberRepository.getById(++currentId).getNumber();
	}
}
