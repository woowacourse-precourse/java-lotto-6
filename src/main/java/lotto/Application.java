package lotto;

import lotto.module.api.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoController.getInstance();
        lottoController.run();
    }
}
