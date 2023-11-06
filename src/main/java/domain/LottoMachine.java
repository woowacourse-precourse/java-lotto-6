package domain;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
	private List<Integer> randomNumbers;

	public LottoMachine() {
		this.randomNumbers = sortRandomNumbers(generateRandomNumbers());
	}

	public List<Integer> getRandomNumbers() {
		return randomNumbers;
	}

	private List<Integer> generateRandomNumbers() {
		return Randoms.pickUniqueNumbersInRange(1, 45, 6);
	}

	private List<Integer> sortRandomNumbers(List<Integer> numbers) {
		return numbers.stream()
				.sorted()
				.collect(Collectors.toList());
	}
}
