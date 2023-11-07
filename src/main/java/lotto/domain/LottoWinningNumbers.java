package lotto.domain;

import static lotto.constant.GameRule.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.validation.LottoValidator;

public class LottoWinningNumbers {
	private List<Integer> winningNumbers;
	private int bonus;

	public LottoWinningNumbers(String input, String bonus) {
		List<Integer> numbers = convertAndvalidateLottos(input);
		validateBonus(bonus);
		this.winningNumbers = numbers;
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}

	private List<Integer> convertToList(String input) {
		return Arrays.stream(input.split(WINNING_INPUT_DELIMITER))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	private List<Integer> convertAndvalidateLottos(String input) {
		List<Integer> numbers = convertToList(input);
		LottoValidator.canBeLotto(numbers);
		return numbers;
	}

	private void validateBonus(String bonus) {
		LottoValidator.validateRange(Integer.parseInt(bonus));
	}
}
