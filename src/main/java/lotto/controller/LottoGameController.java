package lotto.controller;

import lotto.dto.request.UserMoneyDto;
import lotto.util.RetryUtil;
import lotto.view.InputView;

public class LottoGameController {
    private final InputView inputView;

    public LottoGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        createUserMoney();

    }

    private void createUserMoney() {
        UserMoneyDto userMoneyDto = RetryUtil.retryOnFail(inputView::readUserMoney);
    }
}
