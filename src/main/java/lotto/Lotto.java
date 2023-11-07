package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
	private List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 6개가 넘으면 안됩니다.");
		}
		if (!isValidRange(numbers)) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
		}
		if (hasDuplicates(numbers)) {
			throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있으면 안됩니다.");
		}
	}

	public List<Integer> getNumbers(){
		return numbers;
	}

	public static Lotto randomLotto() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);;
		return new Lotto(numbers);
	}

	public int compareNumbers(List<Integer> lottoNumbers) {
		long matchingCount = numbers.stream().filter(lottoNumbers::contains).count();
		return (int) matchingCount;
	}

	private boolean isValidRange(List<Integer> numbers) {
		return numbers.stream().allMatch(num -> num >= 1 && num <= 45);
	}

	private boolean hasDuplicates(List<Integer> numbers) {
		Set<Integer> uniqueNumbers = new HashSet<>(numbers);
		return uniqueNumbers.size() < numbers.size();
	}
}
