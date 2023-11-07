package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.ErrorMessage;
import lotto.ui.Output;

public class Lotto {

	private final List<Integer> numbers;

	public static Lotto of(List<Integer> numbers) {
		validate(numbers);
		return new Lotto(sort(numbers));
	}

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = sort(numbers);
	}

	private static void validate(List<Integer> numbers) {
		validateSize(numbers);
		validateRange(numbers);
		validateDuplicate(numbers);
	}

	private static void validateDuplicate(List<Integer> numbers) {
		numbers.forEach(number -> {
					long count = numbers.stream()
							.filter(number::equals)
							.count();
					if (count > 1) {
						throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
					}
				}
		);
	}

	private static void validateRange(List<Integer> numbers) {
		numbers.forEach(number -> {
			if (number < 1 || number > 45) {
				throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER);
			}
		});
	}

	private static void validateSize(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(ErrorMessage.OUT_OF_LOTTO_NUMBER_SIZE);
		}
	}

	private static List<Integer> sort(List<Integer> numbers) {
		return numbers
				.stream()
				.sorted(Integer::compareTo)
				.collect(Collectors.toList());
	}

	public LottoResult match(Lotto answerLotto, Integer bonusNumber) {
		Long matchCount = answerLotto
				.getNumbers()
				.stream()
				.filter(numbers::contains)
				.count();
		Boolean hasBonusNumber = numbers.contains(bonusNumber);
		return LottoResult.of(matchCount.intValue(), hasBonusNumber);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void printNumbers() {
		Output.integerList(numbers);
	}
}
