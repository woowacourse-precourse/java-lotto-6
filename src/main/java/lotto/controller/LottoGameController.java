package lotto.controller;

import lotto.dto.request.BonusNumberDto;
import lotto.dto.request.UserMoneyDto;
import lotto.dto.request.WinningNumbersDto;
import lotto.dto.response.LottoGroupDto;
import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.LottoGroup;
import lotto.model.LottoMachine;
import lotto.model.LottoNumber;
import lotto.model.NumberGenerator;
import lotto.model.TotalPrize;
import lotto.model.UserMoney;
import lotto.model.WinningTicket;
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

        Lotto winningLotto = RetryUtil.retryOnFail(this::createWinningLotto);
        WinningTicket winningTicket = RetryUtil.retryOnFail(this::createWinningTicket, winningLotto);
        LottoMachine lottoMachine = LottoMachine.of(lottoGroup, winningTicket);
        TotalPrize totalPrize = lottoMachine.calculateTotalPrize();
        outputView.printTotalPrize(totalPrize);

    }

    private LottoCount createLottoCount() {
        UserMoney userMoney = RetryUtil.retryOnFail(this::createUserMoney);
        return LottoCount.from(userMoney);
    }

    private UserMoney createUserMoney() {
        UserMoneyDto userMoneyDto = RetryUtil.retryOnFail(inputView::readUserMoney);
        return UserMoney.from(userMoneyDto.getMoney());
    }

    private void printLottoGroup(LottoGroup lottoGroup) {
        LottoGroupDto lottoGroupDto = LottoGroupDto.from(lottoGroup);
        outputView.printLottoGroup(lottoGroupDto);
    }

    private Lotto createWinningLotto() {
        WinningNumbersDto winningNumbersDto = RetryUtil.retryOnFail(inputView::readWinningNumbers);
        return Lotto.from(winningNumbersDto.getWinningNumbers());
    }

    private WinningTicket createWinningTicket(Lotto winningLotto) {
        LottoNumber bonusNumber = RetryUtil.retryOnFail(this::createBonusNumber);
        return WinningTicket.of(winningLotto, bonusNumber);
    }

    private LottoNumber createBonusNumber() {
        BonusNumberDto bonusNumberDto = RetryUtil.retryOnFail(inputView::readBonusNumber);
        return LottoNumber.from(bonusNumberDto.getBonusNumber());
    }
}
