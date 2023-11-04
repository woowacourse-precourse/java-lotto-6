package lotto.model;

import static lotto.model.constants.LottoRule.LOTTO_NUMBER_LENGTH;
import static lotto.model.constants.LottoRule.MAXIMUM_NUMBER;
import static lotto.model.constants.LottoRule.MINIMUM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumberPicker {

    public static List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER.getValue(),
                MAXIMUM_NUMBER.getValue(), LOTTO_NUMBER_LENGTH.getValue());
    }
}
