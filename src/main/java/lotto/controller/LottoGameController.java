package lotto.controller;

import lotto.dto.request.BonusNumberDto;
import lotto.dto.request.InvestMoneyDto;
import lotto.dto.request.WinningNumbersDto;
import lotto.dto.response.LottoGroupDto;
import lotto.model.InvestMoney;
import lotto.model.Lotto;
import lotto.model.LottoGroup;
import lotto.model.LottoMachine;
import lotto.model.LottoNumber;
import lotto.model.LottoPrice;
import lotto.model.NumberGenerator;
import lotto.model.PurchasableLottoCount;
import lotto.model.TotalPrize;
import lotto.model.TotalProfit;
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
        InvestMoney investMoney = RetryUtil.retryOnFail(this::createInvestMoney);
        LottoGroup lottoGroup = RetryUtil.retryOnFail(this::createLottoGroup, investMoney);
        printLottoGroup(lottoGroup);

        Lotto winningLotto = RetryUtil.retryOnFail(this::createWinningLotto);
        WinningTicket winningTicket = RetryUtil.retryOnFail(this::createWinningTicket, winningLotto);
        LottoMachine lottoMachine = LottoMachine.of(lottoGroup, winningTicket);

        TotalPrize totalPrize = lottoMachine.calculateTotalPrize();
        printTotalPrize(totalPrize);
        TotalProfit totalProfit = totalPrize.calculateTotalProfit(investMoney);
        outputView.printTotalProfit(totalProfit);

    }

    private LottoGroup createLottoGroup(InvestMoney investMoney) {
        PurchasableLottoCount lottoCount = RetryUtil.retryOnFail(this::createLottoCount, investMoney);
        return LottoGroup.create(lottoCount, numberGenerator);
    }

    private PurchasableLottoCount createLottoCount(InvestMoney investMoney) {
        return investMoney.calculatePurchasableLottoCount(LottoPrice.STANDARD_PRICE);
    }

    private void printTotalPrize(TotalPrize totalPrize) {
        outputView.printTotalPrize(totalPrize);
    }

    private InvestMoney createInvestMoney() {
        InvestMoneyDto investMoneyDto = RetryUtil.retryOnFail(inputView::readInvestMoney);
        int investMoney = investMoneyDto.getInvestMoney();
        return InvestMoney.from(investMoney);
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
