package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ui.Output;

import java.util.List;

public class LottoMachine {
    public int getLottoCount(int userMoney) {
        if (userMoney % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(Output.MUST_INPUT_MONEY_UNITS_OF_1000_WON_ERROR);
        }

        return userMoney / Lotto.PRICE;
    }

    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.MIN_VALUE, Lotto.MAX_VALUE, Lotto.NUMBER_OF_MEMBERS);
    }
}
