package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lotto = new LottoController();
        lotto.start();
    }
}
