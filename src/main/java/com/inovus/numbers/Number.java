package com.inovus.numbers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Number {

	@Id @GeneratedValue
	private Long id;
	private String letters;
	private String digits;
	private String region;

	protected Number() {}

	Number(char[] letters, char[] digits) {
		this.letters = String.copyValueOf(letters);
		this.digits = String.copyValueOf(digits);
		this.region = "116 RUS";
	}

	String getNumber() {
		StringBuilder s = new StringBuilder(digits);
		s.insert(0, letters.charAt(0));
		s.append(letters.charAt(1));
		s.append(letters.charAt(2));
		s.append(" ");
		s.append(region);
		return s.toString();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLetters() {
		return letters;
	}

	public void setLetters(String letters) {
		this.letters = letters;
	}

	public String getDigits() {
		return digits;
	}

	public void setDigits(String digits) {
		this.digits = digits;
	}

	public String getRegion() {
		return region;
	}

	public  void setRegion(String region) {
		this.region = region;
	}
}
