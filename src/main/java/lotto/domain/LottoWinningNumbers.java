package lotto.domain;

import static lotto.constant.GameRule.*;

import java.util.Arrays;
import java.util.List;

public class LottoWinningNumbers {
	private List<Integer> winningNumbers;

	public LottoWinningNumbers(String input) {
		this.winningNumbers = convertToList(input);
	}

	private List<Integer> convertToList(String input) {
		return Arrays.stream(input.split(WINNING_INPUT_DELIMITER))
			.map(Integer::parseInt)
			.toList();
	}
}
