package lotto;

import Controller.LottoController;
import Model.Lotto;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        lottoController.buyMyLotto();
        lottoController.assignLotto();
        lottoController.calculateGameResult();
        lottoController.printGameResult();
    }
}
