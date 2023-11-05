package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.ErrorType;
import lotto.domain.Lotto;


public class LottoService {

	private static final int MIN_LOTTO_PRICE = 1000;

	public List<Lotto> purchaseLotto(int price) {
		validate(price);

		int lottoAmount = price / MIN_LOTTO_PRICE;

		return IntStream.range(0, lottoAmount)
			.mapToObj(i -> generateRandomLotto())
			.collect(Collectors.toList());
	}

	private void validate(int price) {
		if (price < MIN_LOTTO_PRICE || price % MIN_LOTTO_PRICE != 0) {
			throw new IllegalArgumentException(ErrorType.INVALID_PURCHASE_ERROR.getErrorMessage());
		}
	}

	private Lotto generateRandomLotto() {
		return new Lotto(Randoms.pickUniqueNumbersInRange(
			Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER, Lotto.MAX_LOTTO_SIZE));
	}

}
