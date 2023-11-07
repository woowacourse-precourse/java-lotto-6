package model;

import camp.nextstep.edu.missionutils.Randoms;
import constants.Constants;
import java.util.List;
import lotto.Lotto;

public class LottoIssuer {

    public Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_RANGE_START,
                Constants.LOTTO_RANGE_END,
                Constants.LOTTO_LENGTH);
        return new Lotto(numbers);
    }
}