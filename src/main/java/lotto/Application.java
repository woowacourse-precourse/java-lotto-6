package lotto;

import lotto.controller.LottoGameController;
import lotto.generator.RandomLottoGenerator;
import lotto.service.LottoGameService;
import lotto.view.LottoGameConsoleView;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(
                new LottoGameService(new RandomLottoGenerator()), new LottoGameConsoleView());
        lottoGameController.run();
    }
}
