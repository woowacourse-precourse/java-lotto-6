package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoApplication {
    private static int LOTTO_PRICE = 1000;

    private Lotto drawLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.START_NUMBER, Lotto.END_NUMBER, 6));
    }

    private int decideNumberOfLotto(int receivedAmount) {
        return receivedAmount / LOTTO_PRICE;
    }
}
