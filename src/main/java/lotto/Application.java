package lotto;

import lotto.controller.LottoGameController;
import lotto.service.LottoGameService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGameService lottoGameService = new LottoGameService();
        LottoGameController lottoGameController = new LottoGameController(inputView, outputView, lottoGameService);
        lottoGameController.start();
    }
}
