package lotto.domain;

import static lotto.config.ErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.config.ErrorMessage.INVALID_LOTTO_NUMBER;
import static lotto.config.ErrorMessage.INVALID_LOTTO_SIZE;
import static lotto.config.LottoConfig.LOTTO_SIZE;

import java.util.Arrays;
import java.util.List;
import lotto.util.NumberUtil;

public class Lotto {

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	private void validate(List<Integer> numbers) {
		if (!checkSize(numbers)) {
			throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
		}

		if (!checkNumberRange(numbers)) {
			throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
		}

		if (!checkDuplication(numbers)) {
			throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
		}
	}

	private boolean checkSize(List<Integer> numbers) {
		return numbers.size() == LOTTO_SIZE.getValue();
	}

	private boolean checkNumberRange(List<Integer> numbers) {
		for (int number : numbers) {
			if (!NumberUtil.isLottoNumberRange(number)) {
				return false;
			}
		}

		return true;
	}

	private boolean checkDuplication(List<Integer> numbers) {
		long count = numbers.stream().distinct().count();

		return count == numbers.size();
	}

	public static Lotto convertToLotto(String numbers) {
		List<Integer> winningNumbers = Arrays.stream(numbers.split(","))
			.map(String::trim)
			.map(Integer::parseInt)
			.toList();

		return new Lotto(winningNumbers);
	}

	public boolean contains(Integer number) {
		return numbers.contains(number);
	}
}