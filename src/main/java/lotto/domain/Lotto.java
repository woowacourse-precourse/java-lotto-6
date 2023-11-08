package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

	private final int MIN_NUM = 1;
	private final int MAX_NUM = 45;
	private final int LOTTO_SIZE = 6;
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		validateDuplicate(numbers);
		validateRange(numbers);

		this.numbers = numbers;
	}

	public List<Integer> getNumbers(){
		return numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != LOTTO_SIZE) {
			System.out.println("[ERROR] 숫자의 개수가 6개가 아닙니다.");
			throw new IllegalArgumentException();
		}
	}

	private void validateDuplicate(List<Integer> numbers) {
		Set<Integer> duplicateCheck = new HashSet<>(numbers);

		if (duplicateCheck.size() != LOTTO_SIZE) {
			System.out.println("[ERROR] 중복된 값이 존재합니다.");
			throw new IllegalArgumentException();
		}
	}

	private void validateRange(List<Integer> numbers) {
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) < MIN_NUM || numbers.get(i) > MAX_NUM) {
				System.out.println("[ERROR] 수가 1 ~ 45의 범위 내에 존재하지 않습니다.");
				throw new IllegalArgumentException();
			}
		}
	}
}
