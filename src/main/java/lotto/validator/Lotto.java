package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		duplicationValidate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("당첨번호를 6개 입력해주세요");
		}
	}

	private void duplicationValidate(List<Integer> numbers) {
		Set<Integer> noDuplicationNum = new HashSet<>(numbers);
		if (noDuplicationNum.size() != numbers.size()) {
			throw new IllegalArgumentException("중복된 숫자가 있습니다. 다시 입력해주세요.");
		}
	}

}
