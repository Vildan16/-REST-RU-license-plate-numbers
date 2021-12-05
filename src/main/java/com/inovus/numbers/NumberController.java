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
	private final List<Long> used = new ArrayList<>();
	private long randomId = 0L;
	NumberController(NumberRepository numberRepository) {
		this.numberRepository = numberRepository;
	}

	@GetMapping(path = "/number/random", produces = "text/plain")
	String random() {
		long qty = numberRepository.count();
		used.add(0L);
		while (used.contains(randomId)) {
			int c = 0;
			randomId = (int) (Math.random() * qty);
			c++;
			if (c >= qty)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Number not found");
		}
		currentId = randomId;
		used.add(currentId);
		return numberRepository.getById(currentId).getNumber();
	}

	@GetMapping(path = "/number/next", produces = "text/plain")
	String next() {
		return numberRepository.getById(++currentId).getNumber();
	}
}
