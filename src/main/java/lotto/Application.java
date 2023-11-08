package lotto;

import lotto.controller.LottoController;
import lotto.model.WinningNumbers;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.purchase();
        lottoController.setWinningNumbers();
        lottoController.makeResult();
    }
}
