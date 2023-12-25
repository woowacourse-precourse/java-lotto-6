package lotto.model;

import static lotto.constants.LottoDetails.LOTTO_NUMBER_MAX;
import static lotto.constants.LottoDetails.LOTTO_NUMBER_MIN;
import static lotto.constants.LottoDetails.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumbersGenerator {

    public static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_SIZE);
    }
}
