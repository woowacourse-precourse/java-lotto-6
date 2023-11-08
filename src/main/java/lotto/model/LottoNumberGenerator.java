package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Constant;

import java.util.List;

public class LottoNumberGenerator {
	public static List<Integer> randomLottoNumber() {
		return Randoms.pickUniqueNumbersInRange(
				Constant.LOTTO_MIN_NUMBER,
				Constant.LOTTO_MAX_NUMBER,
				Constant.LOTTO_SIZE
		);
	}
}
