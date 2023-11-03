package lotto.controller;

import lotto.dto.request.UserMoneyDto;
import lotto.dto.response.LottoGroupDto;
import lotto.model.LottoCount;
import lotto.model.LottoGroup;
import lotto.model.NumberGenerator;
import lotto.model.UserMoney;
import lotto.util.RetryUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public LottoGameController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        LottoCount lottoCount = RetryUtil.retryOnFail(this::createLottoCount);
        LottoGroup lottoGroup = LottoGroup.create(lottoCount, numberGenerator);
        printLottoGroup(lottoGroup);

    }

    private LottoCount createLottoCount() {
        UserMoney userMoney = RetryUtil.retryOnFail(this::createUserMoney);
        return LottoCount.from(userMoney);
    }

    private void printLottoGroup(LottoGroup lottoGroup) {
        LottoGroupDto lottoGroupDto = LottoGroupDto.from(lottoGroup);
        outputView.printLottoGroup(lottoGroupDto);
    }

    private UserMoney createUserMoney() {
        UserMoneyDto userMoneyDto = RetryUtil.retryOnFail(inputView::readUserMoney);
        return UserMoney.from(userMoneyDto.getMoney());
    }
}
