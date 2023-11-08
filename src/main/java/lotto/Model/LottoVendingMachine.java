package lotto.Model;

import static lotto.Global.Constants.LOTTO_NUMBER_AMOUNT;
import static lotto.Global.Constants.LOTTO_NUMBER_MAX_RANGE;
import static lotto.Global.Constants.LOTTO_NUMBER_MIN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoVendingMachine {

    public Lotto createValidLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN_RANGE,
                LOTTO_NUMBER_MAX_RANGE,
                LOTTO_NUMBER_AMOUNT);
        return new Lotto(randomNumbers);
    }

}
