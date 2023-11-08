package lotto.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckValidateInputTest {

	CheckValidateInput checkValidateInput;
	@BeforeEach
	void set() {
		checkValidateInput = new CheckValidateInput();
	}
	
	@Test
	void money_입력_메서드_숫자가_아닌_값_입력시_예외_발생() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        checkValidateInput.money("not a number");
	    });
	}

	@Test
	void money_입력_메서드_1000단위가_아닌_값_입력시_예외_발생() {
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        checkValidateInput.money("250");
	    });
	}

	@Test
	void money_입력_메서드_허용범위_밖의_값_입력시_예외_발생() {
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        checkValidateInput.money("10,000,000,000");
	    });
	}

}
