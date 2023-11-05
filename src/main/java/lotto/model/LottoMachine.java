package lotto.model;

import static lotto.constants.LottoRule.LOTTO_NUMBER_LENGTH;
import static lotto.constants.LottoRule.MAXIMUM_NUMBER;
import static lotto.constants.LottoRule.MINIMUM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachine {

    public static List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER.getValue(),
                MAXIMUM_NUMBER.getValue(), LOTTO_NUMBER_LENGTH.getValue());
    }
}
