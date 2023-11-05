package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoNumberRandomGenerator;
import lotto.model.NumberGenerator;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new LottoNumberRandomGenerator();

        LottoController lottoController = new LottoController(numberGenerator);
        lottoController.start();
    }
}
