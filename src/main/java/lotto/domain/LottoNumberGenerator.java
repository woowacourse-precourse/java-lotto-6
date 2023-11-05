package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_MAX;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_MIN;

public class LottoNumberGenerator {
    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, 6);
    }
}
