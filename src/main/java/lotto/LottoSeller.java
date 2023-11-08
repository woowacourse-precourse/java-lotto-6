package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoSeller {
	private static final int LOTTO_PRICE = 1000;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private static final int LOTTO_COUNT = 6;

	public List<Lotto> sellLotto(final int amount) {
		final var totalQuantity = amount / LOTTO_PRICE;
		final var lottos = new ArrayList<Lotto>();
		for (int i = 0; i < totalQuantity; i++) {
			final var lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_COUNT);
			final var lotto = new Lotto(lottoNumbers);
			lottos.add(lotto);
		}
		return lottos;
	}
}
