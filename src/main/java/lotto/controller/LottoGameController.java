package lotto.controller;

import lotto.dto.request.UserMoneyDto;
import lotto.model.LottoCount;
import lotto.model.UserMoney;
import lotto.util.RetryUtil;
import lotto.view.InputView;

public class LottoGameController {
    private final InputView inputView;

    public LottoGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        RetryUtil.retryOnFail(this::createLottoCount);

    }

    private LottoCount createLottoCount() {
        UserMoney userMoney = RetryUtil.retryOnFail(this::createUserMoney);
        return LottoCount.from(userMoney);
    }

    private UserMoney createUserMoney() {
        UserMoneyDto userMoneyDto = RetryUtil.retryOnFail(inputView::readUserMoney);
        return UserMoney.from(userMoneyDto.getMoney());
    }
}
