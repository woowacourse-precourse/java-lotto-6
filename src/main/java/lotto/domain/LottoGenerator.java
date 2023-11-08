package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
	private static final int MIN_NUM = 1;
	private static final int MAX_NUM = 45;
	private static final int LOTTO_SIZE = 6;

	public static List<Integer> makeLottoList() {
		List<Integer> lottoList = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_SIZE);
		return lottoList;
	}
}
