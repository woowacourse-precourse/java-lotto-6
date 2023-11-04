package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import validators.InputException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        InputException.checkNumberRange(numbers);
        InputException.checkOverlap(numbers);
        this.numbers = numbers;
    }

	private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
	
	// TODO: 추가 기능 구현
	public static List<Integer> divideText(String lottoNumberText) {
		List<String> numberTextList = Arrays.asList(lottoNumberText.split(",", -1));
		List<Integer> numberList = new ArrayList<>();
		for(String numberText : numberTextList) {
			int number = Integer.valueOf(numberText);
			numberList.add(number);
		}
		return numberList;
	}
}
