package domain;

import camp.nextstep.edu.missionutils.Console;

public class LottoPurchaseManager {

    static final int PRICE_OF_LOTTO = 1000;

    public int calculateNumOfLotto(int purchaseAmount) {
        if (purchaseAmount % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + PRICE_OF_LOTTO + "원으로 나누어 떨어져야 합니다.");
        }
        return purchaseAmount / PRICE_OF_LOTTO;
    }
}
