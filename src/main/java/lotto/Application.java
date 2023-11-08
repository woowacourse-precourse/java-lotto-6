package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = Configuration.controller();
        lottoController.purchaseLotto();
        lottoController.putWinningNumbers();
        lottoController.putBonusNumber();
        lottoController.getLottoResult();
    }
}
