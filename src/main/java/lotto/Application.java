package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController= LottoController.getInstance();
        lottoController.start();
        // TODO: 프로그램 구현
    }
}
