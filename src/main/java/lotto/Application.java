package lotto;

import lotto.contorller.WinningLottoController;

public class Application {
    public static void main(String[] args) {
        WinningLottoController lottoController = new WinningLottoController();
        lottoController.init();
    }
}
