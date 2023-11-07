package lotto;

import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.purchaseLotto();
        gameController.createLotto();
        gameController.inputWinningLottoNumbers();
        gameController.inputBonusNumber();
        gameController.makeGameResult();
        gameController.printGameResult();
    }
}
