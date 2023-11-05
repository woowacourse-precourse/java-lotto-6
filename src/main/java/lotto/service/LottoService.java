package lotto.service;

import java.util.List;

import lotto.domain.ErrorType;
import lotto.domain.Lotto;

public class LottoService {

	private static final int MIN_LOTTO_PRICE = 1000;

	public List<Lotto> purchaseLotto(int price) {

	}

	private void validate(int price) {
		if (price < MIN_LOTTO_PRICE || price % MIN_LOTTO_PRICE != 0) {
			throw new IllegalArgumentException(ErrorType.INVALID_PURCHASE_ERROR.getErrorMessage());
		}
	}


}
