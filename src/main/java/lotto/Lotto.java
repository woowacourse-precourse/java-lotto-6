package lotto;

import java.util.ArrayList;
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
		List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_NUM_RANGE);
		return new Lotto(randomNumbers);
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != LOTTO_NUM_RANGE || duplicateNumber(numbers)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean duplicateNumber(List<Integer> numbers) {
		if (numbers.size() != numbers.stream().distinct().count()) {
			return true;
		}
		return false;
	}

	public void show() {
		ArrayList<Integer> showNumbers = new ArrayList(numbers);
		showNumbers.sort(Integer::compareTo);
		System.out.println(showNumbers);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
