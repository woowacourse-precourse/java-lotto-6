package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinner {
	public static final int SIZE = 6;
	public static final String DUPLICATE_LOTTO_NUMBER_MESSAGE = "중복된 로또 값이 존재합니다.";
	private final List<LottoNumber> normalLotto = new ArrayList<>();
	private LottoNumber bonusNumber;

	public void addNormal(LottoNumber lottoNumber) {
		validate(lottoNumber);
		normalLotto.add(lottoNumber);
	}

	public void addBonus(LottoNumber lottoNumber) {
		validate(lottoNumber);
		bonusNumber = lottoNumber;
	}

	public boolean hasNormal(LottoNumber lottoNumber) {
		return normalLotto.contains(lottoNumber);
	}

	public boolean hasBonus(LottoNumber lottoNumber) {
		return bonusNumber.equals(lottoNumber);
	}

	public boolean isCorrectSize() {
		return normalLotto.size() == SIZE;
	}

	public boolean hasCorrectBonusNumber() {
		return bonusNumber != null;
	}

	private void validate(LottoNumber lottoNumber) {
		if (isDuplicate(lottoNumber)) {
			throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_MESSAGE);
		}
	}

	private boolean isDuplicate(LottoNumber lottoNumber) {
		return normalLotto.contains(lottoNumber);
	}

}
