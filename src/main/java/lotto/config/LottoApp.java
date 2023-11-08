package lotto.config;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.domain.LottoCollector;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApp {

    private final LottoController lottoController;

    public LottoApp() {
        lottoController = new LottoController(
                LottoConfig.lottoPublishService(),
                LottoConfig.winningService()
        );
    }

    public void run() {
        requestPublishLotto();
        requestWinningNumber();

        Console.close();
    }

    private void requestPublishLotto() {
        while(true) {
            try {
                InputView.printInputBuyAmountRequest();
                LottoCollector lottoCollector = lottoController.publishLotto(Console.readLine());
                OutputView.printPublishedLottos(lottoCollector);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void requestWinningNumber() {
        InputView.printInputWinningNumber();
        String winningNumber = Console.readLine();

        lottoController.createWinningNumber(winningNumber);
    }
}
