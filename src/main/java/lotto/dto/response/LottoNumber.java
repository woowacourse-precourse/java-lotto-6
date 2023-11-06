package lotto.dto.response;

import java.util.List;
import lotto.Lotto;
import lotto.domain.UserLotto;

public class LottoNumber {

	private final List<Integer> numbers;

	public LottoNumber(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
