package lotto.config;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.view.InputView;

public class LottoApp {

    private final LottoController lottoController;

    public LottoApp() {
        lottoController = new LottoController(LottoConfig.lottoPublishService());
    }

    public void run() {
        requestPublishLotto();
    }

    private void requestPublishLotto() {
        while(true) {
            try {
                InputView.printInputBuyAmountRequest();
                lottoController.publishLotto(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
