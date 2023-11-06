package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {
	private static final int NUMBERS_SIZE = 6;
	private static final String HIT_MESSAGE = "개 일치";
	private static final String BONUS_HIT_MESSAGE = "개 일치, 보너스 볼 일치";

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {

		validateSize(numbers);
		validateDuplication(numbers);

		Collections.sort(numbers);

		this.numbers = numbers;
	}

	private void validateSize(List<Integer> numbers) {

		if (numbers.size() != NUMBERS_SIZE) {
			throw new IllegalArgumentException();
		}
	}

	private void validateDuplication(List<Integer> numbers) {

		Set<Integer> testNumbers = Set.copyOf(numbers);

		if (testNumbers.size() != NUMBERS_SIZE) {
			throw new IllegalArgumentException();
		}
	}

	public String match(List<Integer> winningNumber, int bonusNumber) {

		int hitCount = calculateHit(winningNumber);

		if (isBonusHit(bonusNumber, hitCount)) {
			return hitCount + BONUS_HIT_MESSAGE;
		}

		return hitCount + HIT_MESSAGE;
	}

	private int calculateHit(List<Integer> winningNumber) {

		int hitCount = 0;

		for (int comparedNumber : winningNumber) {

			if (isHit(comparedNumber)) {
				hitCount++;
			}
		}

		return hitCount;
	}

	private boolean isHit(int comparedNumber) {
		return numbers.contains(comparedNumber);
	}

	private boolean isBonusHit(int bonusNumber, int hitCount) {
		return hitCount == 5 && numbers.contains(bonusNumber);
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}

}
