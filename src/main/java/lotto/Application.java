package lotto;

import lotto.controller.LottoController;
import lotto.generator.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new RandomNumberGenerator());
        lottoController.play();
    }
}
