package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

	private static final Integer LOTTO_PRICE = 1000;
	private static final Integer LOTTO_MIN_NUMBER = 1;
	private static final Integer LOTTO_MAX_NUMBER = 45;
	private static final Integer LOTTO_COUNT = 6;

	public Lottos buyLottos(Integer money) {
		List<Lotto> lottos = new ArrayList<>();
		while (isExistBalance(money)) {
			money -= LOTTO_PRICE;
			Lotto of = Lotto.of(generateNumbers());
			lottos.add(of);
		}
		return Lottos.of(lottos);
	}

	private static List<Integer> generateNumbers() {
		return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_COUNT);
	}

	private boolean isExistBalance(Integer money) {
		return money > 0;
	}
}
