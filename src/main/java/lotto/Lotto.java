package lotto;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
	private List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers.stream().collect(Collectors.toList());;
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
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		List<Integer> sortednumbers = numbers.stream().sorted().toList();
		return new Lotto(sortednumbers);
	}

	public long compareNumbers(List<Integer> lottoNumbers) {
		return numbers.stream().filter(lottoNumbers::contains).count();
	}

	private boolean isValidRange(List<Integer> numbers) {
		return numbers.stream().allMatch(num -> num >= 1 && num <= 45);
	}

	private boolean hasDuplicates(List<Integer> numbers) {
		long distinctCount = numbers.stream().distinct().count();
		return distinctCount != numbers.size();
	}
}
