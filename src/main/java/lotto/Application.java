package lotto;

import lotto.controller.LottoGame;
import lotto.view.LottoUI;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = LottoUI.getPurchaseAmount();
        LottoGame lottoGame = new LottoGame(purchaseAmount);
        lottoGame.play();
    }
}
