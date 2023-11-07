package lotto.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator {
	private final static int NUMBER_OF_LOTTO_NUMBERS = 6;
	private final static int MIN_LOTTO_NUMBER = 1;
	private final static int MAX_LOTTO_NUMBER = 45;
	public List<Integer> generateLottoNumber() {
		return Randoms.pickUniqueNumbersInRange(1, 45, 6);
	}
}
