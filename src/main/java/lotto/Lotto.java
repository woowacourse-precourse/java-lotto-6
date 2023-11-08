package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
	public final static int MAX_LOTTO_NUM = 45;
	public final static int MIN_LOTTO_NUM = 1;
	public final static int LOTTO_NUM_RANGE = 6;

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	static public Lotto createLotto() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_NUM_RANGE);
		return new Lotto(numbers);
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != LOTTO_NUM_RANGE) {
			throw new IllegalArgumentException();
		}
	}

	public void show() {
		System.out.println(numbers);
	}
}
