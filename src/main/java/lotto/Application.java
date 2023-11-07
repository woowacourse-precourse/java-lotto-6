package lotto;

import lotto.application.LottoService;
import lotto.controller.LottoGameController;
import lotto.domain.LottoGenerator;
import lotto.domain.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(
                new LottoService(
                        new LottoGenerator(new RandomNumberGenerator())));
        lottoGameController.lottoGame();
    }
}
