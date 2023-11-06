package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Controller;

import java.util.List;

public class LottoMachine {
    public int getLottoCount(int userMoney) {
        if (userMoney % Lotto.PRICE != 0) {
            Controller.lottoPurchaseAmountException();
        }

        return userMoney / Lotto.PRICE;
    }

    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.MIN_VALUE, Lotto.MAX_VALUE, Lotto.NUMBER_OF_MEMBERS);
    }
}
