package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoNumberGenerator;
import lotto.model.NumberGenerator;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new LottoNumberGenerator();

        LottoController lottoController = new LottoController(numberGenerator);
        lottoController.start();
    }
}
