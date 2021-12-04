package com.inovus.numbers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Number {

	@Id @GeneratedValue
	private Long id;
	private char[] letters;
	private String digits;
	private int region;

	protected Number() {}

	Number(char[] letters, char[] digits) {
		this.letters = letters;
		this.digits = String.copyValueOf(digits);
		this.region = 116;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public char[] getLetters() {
		return letters;
	}

	public void setLetters(char[] letters) {
		this.letters = letters;
	}

	public String getDigits() {
		return digits;
	}

	public void setDigits(String digits) {
		this.digits = digits;
	}

	public int getRegion() {
		return region;
	}

	public void setRegion(int region) {
		this.region = region;
	}
}
