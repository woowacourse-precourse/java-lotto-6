package lotto.controller;

import lotto.dto.request.UserMoneyDto;
import lotto.model.LottoCount;
import lotto.model.LottoGroup;
import lotto.model.NumberGenerator;
import lotto.model.UserMoney;
import lotto.util.RetryUtil;
import lotto.view.InputView;

public class LottoGameController {
    private final InputView inputView;
    private final NumberGenerator numberGenerator;

    public LottoGameController(InputView inputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        LottoCount lottoCount = RetryUtil.retryOnFail(this::createLottoCount);
        LottoGroup lottoGroup = LottoGroup.create(lottoCount, numberGenerator);

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
