package lotto;

import lotto.controller.LottoGameController;
import lotto.service.InputService;
import lotto.service.LottoGameService;
import lotto.service.OutputService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputService inputService = new InputService(inputView);

        OutputView outputView = new OutputView();
        OutputService outputService = new OutputService(outputView);

        LottoGameService lottoGameService = new LottoGameService(inputService, outputService);

        LottoGameController game = new LottoGameController(lottoGameService);
        game.play();
    }
}
