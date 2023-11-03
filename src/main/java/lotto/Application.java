package lotto;

import lotto.controller.MainLottoController;

public class Application {
    public static void main(String[] args) {
        MainLottoController mainLottoController = new MainLottoController();
        mainLottoController.startLotto();
    }
}
