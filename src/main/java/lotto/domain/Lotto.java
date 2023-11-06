package lotto.domain;

import java.util.List;

import lotto.validation.Validation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
    	validate(numbers);
        this.numbers = numbers;
    }
    
	public static void validate (List<Integer> numbers) {
		Validation.validateLottoSize(numbers);
		Validation.validateDistinctedNumbers(numbers);
    }
}
