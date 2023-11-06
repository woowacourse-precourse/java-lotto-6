package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
	
    public static void validateDistinctedNumbers(List<Integer> numbers) {
    	Set<Integer> DistinctedNumbers = new HashSet<Integer>(numbers);
    	if (numbers.size() != DistinctedNumbers.size()) {
    		throw new IllegalArgumentException();
		}
    }
    
    public static void validateListNumbersInRange(List<Integer> numbers, int startInclusive, int endInclusive) {
		for (Integer number : numbers) {
			validateNumberInRange(number, startInclusive, endInclusive);
		}
	}
	public static void validateNumberInRange(int number, int startInclusive, int endInclusive) {
		if (number < startInclusive || number > endInclusive) {
			throw new IllegalArgumentException();
		}
	}
	
	public static void validateNaturalNumber(String input) {
		if (!input.matches("\\d+")) {
			throw new IllegalArgumentException();
		}
	}
	
	public static void validateNaturalNumberList(List<String> inputStirng) {
		for (String value : inputStirng) {
			validateNaturalNumber(value);
		}
	}
	
	public static void validateNumberNotInList(List<Integer> list, int number) {
		if (list.contains(number)) {
			throw new IllegalArgumentException();
		}
	}

}
