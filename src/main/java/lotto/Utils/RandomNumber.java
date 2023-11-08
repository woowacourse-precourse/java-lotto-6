package lotto.Utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.Utils.LottoConstantNumbers.*;

public class RandomNumber {

    public static List<Integer> generator() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getValue(),
                MAX_LOTTO_NUMBER.getValue(), LOTTO_NUMBER_COUNT.getValue());
    }
}
