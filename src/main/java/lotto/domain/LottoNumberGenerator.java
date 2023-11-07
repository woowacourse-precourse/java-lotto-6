package lotto.domain;

import static lotto.domain.LottoNumber.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator {
	public static List<Integer> generateLottoNumber() {
		return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(),
			NUMBER_OF_LOTTO_NUMBERS.getValue());
	}
}
