package lotto;

import lotto.lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = LottoController.getInstance();
        lottoController.start();
    }
}
