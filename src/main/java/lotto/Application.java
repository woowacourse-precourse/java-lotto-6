package lotto;

import lotto.controller.LottoController;
import lotto.domain.NumberGenerator;
import lotto.domain.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        LottoController lottoController = new LottoController(numberGenerator);
        lottoController.run();
    }
}
