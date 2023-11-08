package lotto;

import lotto.controller.LottoController;
import lotto.util.RandomsWrapper;
import lotto.util.ResultCalculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(new RandomsWrapper(), new ResultCalculator());
        lottoController.run();
    }
}
