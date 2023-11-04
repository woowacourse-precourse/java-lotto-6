package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoChecker;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(new LottoChecker());
        lottoController.start();
    }
}
