package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.vo.LottoNumbers;

public class Lotto {
	private final List<LottoNumbers> numbers;

	public Lotto(int amount) {
		this.numbers = IntStream.range(0, amount)
				.mapToObj(LottoNumbers::new)
				.toList();
	}

	public List<LottoNumbers> getLotto() {
		return numbers;
	}
}
