package lotto.controller;

import lotto.domain.Price;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView;
    OutputView outputView;
    User user;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.user = user;
    }

    public void run() {
        issueLotto();
        getWinningNumbers();
        printLottoResult();
    }

    private void issueLotto() {
        inputView.requestPurchasePrice();
        Price price = user.requestPurchasePrice();


    }

    private void getWinningNumbers() {

    }

    private void printLottoResult() {

    }
}
