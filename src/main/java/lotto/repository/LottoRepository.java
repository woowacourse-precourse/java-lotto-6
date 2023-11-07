package lotto.repository;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.global.util.Constants;
import lotto.model.Lotto;

public class LottoRepository {
	public Lotto createLotto() {
		return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, Constants.LOTTO_NUMBER_COUNT.value));
	}
}