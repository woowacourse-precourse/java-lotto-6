package lotto.config;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.domain.LottoCollector;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApp {

    private final LottoController lottoController;
    private LottoCollector lottoCollector;

    public LottoApp() {
        lottoController = new LottoController(
                LottoConfig.lottoPublishService(),
                LottoConfig.winningService()
        );
    }

    public void run() {
        requestPublishLotto();
        requestWinningNumber();
        requestBonusNumber();
        requestPrizeMoney();

        Console.close();
    }

    private void requestPublishLotto() {
        while (true) {
            try {
                InputView.printInputBuyAmountRequest();
                lottoCollector = lottoController.publishLotto(Console.readLine());
                OutputView.printPublishedLottos(lottoCollector);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void requestWinningNumber() {
        while (true) {
            try {
                InputView.printInputWinningNumber();
                String winningNumber = Console.readLine();

                lottoController.createWinningNumber(winningNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void requestBonusNumber() {
        while (true) {
            try {
                InputView.printInputBonusNumber();
                String bonusNumber = Console.readLine();

                lottoController.createBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void requestPrizeMoney() {
        String winningDetail = lottoController.getWinningDetail(lottoCollector);
        OutputView.winningDetail(winningDetail);
    }
}
