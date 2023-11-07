package lotto;

import lotto.Controller.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 로또 구현
        LottoController lottoController = LottoController.getInstance();
        lottoController.run();
    }
}
