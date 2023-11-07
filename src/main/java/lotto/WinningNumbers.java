//WinningNumbers.java
package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.Constant.LottoInfo;
import lotto.Enum.ErrorMessage;

public class WinningNumbers {
	private List<Integer> winningNumbers = new ArrayList<>();

	public WinningNumbers(String input){
		validate(input);
		this.winningNumbers = changeStringToList(input);
	}


	public boolean have(Integer number){
		return winningNumbers.contains(number);
	}

	public int checkMatchCounts(Lotto lotto){
		int count = 0;
		for(Integer winningNumber : winningNumbers){
			if(lotto.have(winningNumber)){
				count++;
			}
		}
		return count;
	}

	private void validate(String input){
		String[] splitedInputs = input.trim().split(",");

		checkFormat(input);
		checkNumberOfNumbers(splitedInputs);
		checkNumberRangeAndUniqueness(splitedInputs);
	}

	private void checkFormat(String input) {
		if (!input.contains(",")) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT.getMessage());
		}
	}

	private void checkNumberOfNumbers(String[] splitedInputs) {
		if (splitedInputs.length != LottoInfo.getNUMBER_COUNT()) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getMessage());
		}
	}

	private void checkNumberRangeAndUniqueness(String[] splitedInputs) {
		Set<Integer> uniqueNumbers = new HashSet<>();

		for (String value : splitedInputs) {
			int number = parseNumber(value);

			if (number < LottoInfo.getMIN_NUMBER() || number > LottoInfo.getMAX_NUMBER()) {
				throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
			}

			if (uniqueNumbers.contains(number)) {
				throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
			}
			uniqueNumbers.add(number);
		}
	}

	private List<Integer> changeStringToList(String input){
		return Arrays.stream(input.split(","))
			.map(this::parseNumber)
			.collect(Collectors.toList());
	}

	private int parseNumber(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
		}
	}
}
