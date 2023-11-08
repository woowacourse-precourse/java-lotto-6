package lotto;

import lotto.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller lottoController = Controller.generateLottoController();
        lottoController.programStart();
    }
}
