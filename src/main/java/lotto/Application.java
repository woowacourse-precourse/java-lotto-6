package lotto;

import lotto.control.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.simulate();
    }
}
