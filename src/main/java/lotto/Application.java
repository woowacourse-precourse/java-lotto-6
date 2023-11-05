package lotto;

import lotto.ioManager.LottoIoManager;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoIoManager());

        lottoController.run();
    }
}
