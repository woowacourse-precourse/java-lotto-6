package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CheckValidateInput {

	private final String NOT_NUMBER_MESSAGE = "숫자를 입력해야합니다.";
	private final String NOT_UNITS_1000_MESSAGE = "1,000원 단위의 금액을 입력해야합니다.";
	private final String NOT_IN_RANGE_MONEY_MESSAGE = "0보다 큰 값을 입력해야합니다.";
	private final String NOT_IN_RANGE_NUMBER_MESSAGE = "1~45 사이의 숫자를 입력해야합니다.";

	private final String ERROR_MESSAGE_TAG = "[ERROR] ";
	private final int MONEY_UNIT = 1000;
	private final int ZERO = 0;
	private final int MAX_VALUE = Integer.MAX_VALUE;
	private final int MAX_LOTTO_NUMBER = 45;
	private final String COMMA = ",";

	public int money(String money) {

		if (!isNumber(money))
			throw new IllegalArgumentException(ERROR_MESSAGE_TAG + NOT_NUMBER_MESSAGE);
		if (!isUnits1000(Integer.parseInt(money)))
			throw new IllegalArgumentException(ERROR_MESSAGE_TAG + NOT_UNITS_1000_MESSAGE);
		if (!inRangeMoney(Integer.parseInt(money)))
			throw new IllegalArgumentException(ERROR_MESSAGE_TAG + NOT_IN_RANGE_MONEY_MESSAGE);

		return Integer.parseInt(money);
	}

	private boolean isUnits1000(int money) {
		return (money % MONEY_UNIT) == ZERO;
	}

	private boolean inRangeMoney(int money) {
		return (money > ZERO) && (money < MAX_VALUE);
	}

	public int bonusNumber(String bonusNumber) {

		if (!isNumber(bonusNumber))
			throw new IllegalArgumentException(ERROR_MESSAGE_TAG + NOT_NUMBER_MESSAGE);
		if (!inRangeNumber(Integer.parseInt(bonusNumber)))
			throw new IllegalArgumentException(ERROR_MESSAGE_TAG + NOT_IN_RANGE_NUMBER_MESSAGE);

		return Integer.parseInt(bonusNumber);
	}



	public List<Integer> winningNumber(String numbers) {

		if (!isNumbersInteger(separated(numbers)))
			throw new IllegalArgumentException(ERROR_MESSAGE_TAG + NOT_NUMBER_MESSAGE);

		List<Integer> winnings = Arrays
				.stream(separated(numbers))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		
		if(!isRangeWinningNumber(winnings))
			throw new IllegalArgumentException(ERROR_MESSAGE_TAG+NOT_IN_RANGE_NUMBER_MESSAGE);
		sort(winnings);
		return winnings;
	}

	private boolean isRangeWinningNumber(List<Integer> winningNumbers) {
		for(int winningNumber : winningNumbers) {
			if(!inRangeNumber(winningNumber))
				return false;
		}
		return true;
	}
	
	private void sort(List<Integer> numbers) {
		Collections.sort(numbers);
	}

	private String[] separated(String numbers) {
		return numbers.split(COMMA);
	}

	private boolean isNumbersInteger(String[] numbers) {
		for (String number : numbers) {
			if (!isNumber(number))
				return false;
		}
		return true;
	}
	
	private boolean inRangeNumber(int Number) {
		return (Number > ZERO) && (Number <= MAX_LOTTO_NUMBER);
	}

	private boolean isNumber(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException numberFormatException) {
			return false;
		}
	}
}
