package domain;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
	private static final int LOTTO_SIZE = 6;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	private final List<Integer> randomNumbers;

	public LottoMachine() {
		this.randomNumbers = sortRandomNumbers(generateRandomNumbers());
	}

	public List<Integer> getRandomNumbers() {
		return randomNumbers;
	}

	private List<Integer> generateRandomNumbers() {
		return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
	}

	private List<Integer> sortRandomNumbers(List<Integer> numbers) {
		return numbers.stream()
				.sorted()
				.collect(Collectors.toList());
	}
}
