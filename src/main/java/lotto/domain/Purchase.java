package lotto.domain;

import static lotto.domain.Money.DIVISION_FACTOR;

public class Purchase {

    private final int purchaseLotto;

    public Purchase(int money) {
        this.purchaseLotto = countPurchaseLotto(money);
    }

    private int countPurchaseLotto(int money) {
        return money / DIVISION_FACTOR;
    }

    public int getPurchaseLotto() {
        return purchaseLotto;
    }
}