package lotto.utility;

import static lotto.constant.LottoConstant.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
	public static List<Integer> getLottoNumbers() {
		return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(), PICK_COUNT.getValue());
	}
}
