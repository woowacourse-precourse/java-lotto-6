package lotto.util;

import static lotto.model.constant.LottoConfig.LOTTO_SIZE;
import static lotto.model.constant.LottoConfig.MAXIMUM_LOTTO_NUMBER;
import static lotto.model.constant.LottoConfig.MINIMUM_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumbersGenerator {

    public static List<Integer> lottoNumbersGenerator() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_SIZE);
    }
}
