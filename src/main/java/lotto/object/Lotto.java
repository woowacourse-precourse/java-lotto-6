package lotto.object;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateNumber(numbers);
		validateRange(numbers);
		validateDuplication(numbers);
		this.numbers = numbers;
	}

	private void validateNumber(List<Integer> numbers) {
		if (numbers.size() != 6) {
			System.out.println("[ERROR] 6개 숫자를 입력하세요.");
			throw new IllegalArgumentException("[ERROR] 6개 숫자를 입력하세요.");
		}
	}

	private void validateRange(List<Integer> numbers) {
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) < 1 || numbers.get(i) > 45) {
				System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
				throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
			}
		}
	}

	private void validateDuplication(List<Integer> numbers) {
		Set<Integer> noDuplication = new HashSet<Integer>(numbers);
		if (noDuplication.size() != numbers.size()) {
			System.out.println("[ERROR] 로또 번호는 중복을 허용하지 않습니다.");
			throw new IllegalArgumentException("[ERROR] 로또 번호는 중복을 허용하지 않습니다.");
		}
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}
}
