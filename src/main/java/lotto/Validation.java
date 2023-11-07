package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Validation {
	protected static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] You must input 6 winning numbers.");
        }
    }

    protected static void validatePurchaseAmount(int lottoTrials) throws IllegalArgumentException {
		if (lottoTrials % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] You must input purchase amount can be devided into 1000.");
		}
	}
    
    protected static void validateNumberRange(List<Integer> numbers) throws IllegalArgumentException {
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) > 45 || numbers.get(i) < 1) {
				throw new IllegalArgumentException("[ERROR] You must input winning numbers between 1 to 45.");
			}
		}
	}
	
	protected static void validateNumberRange(int bonusNumber) throws IllegalArgumentException {
		if (bonusNumber > 45 || bonusNumber < 1) {
			throw new IllegalArgumentException("[ERROR] You must input winning numbers between 1 to 45.");
		}
	}
	
	protected static void validateNumberDuplication(List<Integer> numbers) throws IllegalArgumentException {
		Set<Integer> distinctNumbers = new HashSet<>(numbers);
		if (distinctNumbers.size() != numbers.size()) {
			throw new IllegalArgumentException("[ERROR] : You must not input duplicated numbers.");
		}
	}
	
	protected static void validateNumberDuplication(List<Integer> numbers, int bonusNumber)
			throws IllegalArgumentException {
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) == bonusNumber) {
				throw new IllegalArgumentException("[ERROR] : You must not input duplicated numbers.");
			}
		}
	}
	
	protected static void validateNonIntegerInput(String inputAmount) throws IllegalArgumentException {
		for (int i = 0; i < inputAmount.length(); i++) {
			if (inputAmount.charAt(i) < '0' || inputAmount.charAt(i) > '9') {
				throw new IllegalArgumentException("[ERROR] You must input integer value.");
			}
		}
	}
}
