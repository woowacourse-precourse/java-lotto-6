package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lotto_controller = new LottoController();
        lotto_controller.run();
    }
}
