package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
	public static final String DUPLICATE_LOTTO_NUMBER_MESSAGE = "[Error] 중복된 로또 값이 존재합니다.";
	public static final int PRICE = 1000;
	public static final int SIZE = 6;
	private final List<LottoNumber> lotto = new ArrayList<>();

	public void add(LottoNumber lottoNumber) {
		validate(lottoNumber);
		lotto.add(lottoNumber);
	}

	private void validate(LottoNumber lottoNumber) {
		if (isDuplicate(lottoNumber)) {
			throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_MESSAGE);
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
