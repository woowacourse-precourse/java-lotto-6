package lotto.v3.controller;

import lotto.v3.view.LottoPurchaseView;

public class LottoPurchaseController {

    private static final int LOTTO_PRICE = 1000; // 로또 1장의 가격
    private final LottoPurchaseView lottoPurchaseView;

    public LottoPurchaseController(LottoPurchaseView lottoPurchaseView) {
        this.lottoPurchaseView = lottoPurchaseView;
    }

    private void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

}
