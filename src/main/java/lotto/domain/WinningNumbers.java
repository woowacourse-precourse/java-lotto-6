package lotto.domain;

import static lotto.constant.GameRule.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.validation.LottoValidator;

public class WinningNumbers {
	private List<Integer> winningNumbers;

	public WinningNumbers(String input) {
		this.winningNumbers = validateAndGetWinningNumbers(input);
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}

	public int compareWith(Lotto lotto) {
		return (int) lotto.getLotto().stream()
			.filter(l -> winningNumbers.contains(l))
			.count();
	}

	private List<Integer> convertToList(String input) {
		return Arrays.stream(input.split(WINNING_INPUT_DELIMITER))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	private List<Integer> validateAndGetWinningNumbers(String input) {
		List<Integer> numbers = convertToList(input);
		LottoValidator.canBeLotto(numbers);
		return numbers;
	}
}
