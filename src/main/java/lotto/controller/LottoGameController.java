package lotto.controller;

import lotto.model.Message;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    InputView inputView;
    OutputView outputView;
    LottoGameService lottoGameService;

    public LottoGameController(InputView inputView, OutputView outputView, LottoGameService lottoGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGameService = lottoGameService;
    }

    public void run() {
        enterMoney();
        makeLotto();
    }

    private void makeLotto() {
        String lotto = lottoGameService.makeLotto();
    }

    private void enterMoney() {
        printMessage(Message.ASK_MONEY.toString());
        String money = inputView.inputMoney();
        try {
            lottoGameService.buyLotto(money);
        } catch (IllegalArgumentException e) {
            printMessage(e.getMessage());
            enterMoney();
        }
    }

    private void printMessage(String message) {
        outputView.printMessage(message);
    }
}
