package lotto;

import lotto.controller.GameController;
import lotto.domain.Generator;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoManager;

public class Application {
    public static void main(String[] args) {
        Generator generator = new LottoGenerator();
        LottoManager lottoManager = LottoManager.from(generator);
        GameController gameController = new GameController(lottoManager);
        gameController.run();
    }
}
