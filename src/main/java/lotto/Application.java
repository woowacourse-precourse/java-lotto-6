package lotto;

import lotto.controller.LottoController;
import lotto.util.random.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new RandomNumberGenerator());
        lottoController.run();
    }
}
