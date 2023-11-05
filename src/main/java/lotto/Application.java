package lotto;

import lotto.validator.LottoPurchaseAmountValidator;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new LottoPurchaseAmountValidator());
        lottoGame.start();
    }
}
