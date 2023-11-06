package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class PurchaseService {

	public List<Lotto> purchaseLotto(int money) {
		int amount = calculateAmountLotto(money);
		return IntStream.range(0, amount)
			.mapToObj(lotto -> generateRandomLotto())
			.collect(Collectors.toList());
	}

	private Lotto generateRandomLotto() {
		Lotto lotto = new Lotto();
		Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER, Lotto.SIZE).stream()
			.map(LottoNumber::from)
			.forEach(lotto::add);
		return lotto;
	}

	private int calculateAmountLotto(int money) {
		return money / Lotto.PRICE;
	}
}
