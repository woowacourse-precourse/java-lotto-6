package lotto.controller;

import lotto.domain.Price;
import lotto.domain.UserLottos;
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
        this.user = new User();
    }

    public void run() {
        issueLotto();
        getWinningNumbers();
        printLottoResult();
    }

    private void issueLotto() {
        // 구매 가격 받아오기
        inputView.requestPurchasePrice();
        Price price = user.requestPurchasePrice();

        // 로또 발행
        UserLottos userLottos = user.generateAllLottos(price);

    }

    private void getWinningNumbers() {

    }

    private void printLottoResult() {

    }
}
