package lotto;

import lotto.controller.LottoController;
import lotto.utils.generator.RandomLottosGenerator;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new RandomLottosGenerator());
        lottoController.run();
    }
}
