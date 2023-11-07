package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
	public static final String DUPLICATE_LOTTO_NUMBER_MESSAGE = "중복된 로또 값이 존재합니다.";
	public static final int PRICE = 1000;
	public static final int SIZE = 6;
	private final List<LottoNumber> lotto;

	public Lotto(List<Integer> integers) {
		validate(integers);
		this.lotto = integers.stream()
			.map(LottoNumber::from)
			.collect(Collectors.toList());
	}

	public LottoNumber get(int i) {
		return lotto.get(i);
	}

	private void validate(List<Integer> integers) {
		if (integers.size() != SIZE) {
			throw new IllegalArgumentException("입력된 숫자들의 개수가 올바르지 않습니다.");
		}
		if (integers.stream()
			.anyMatch(i -> integers.indexOf(i) != integers.lastIndexOf(i))) {
			throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
		}
	}

	private boolean isDuplicate(LottoNumber lottoNumber) {
		return lotto.contains(lottoNumber);
	}

	@Override
	public String toString() {
		return "[" +
			lotto.stream()
				.sorted(Comparator.comparingInt(LottoNumber::getNumber))
				.map(LottoNumber::toString)
				.collect(Collectors.joining(", "))
			+ "]";
	}
}
