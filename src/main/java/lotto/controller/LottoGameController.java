package lotto.controller;

import lotto.dto.request.BonusNumberDto;
import lotto.dto.request.InvestmentMoneyDto;
import lotto.dto.request.WinningLottoNumbersDto;
import lotto.dto.response.LottoGroupDto;
import lotto.dto.response.TotalProfitRateDto;
import lotto.model.InvestmentMoney;
import lotto.model.Lotto;
import lotto.model.LottoGroup;
import lotto.model.LottoMachine;
import lotto.model.LottoNumber;
import lotto.model.LottoPrice;
import lotto.model.NumberGenerator;
import lotto.model.PrizeSummary;
import lotto.model.PurchasableLottoCount;
import lotto.model.TotalProfitRate;
import lotto.model.WinningCombination;
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
        InvestmentMoney investmentMoney = RetryUtil.retryOnFail(this::createInvestmentMoney);

        LottoGroup lottoGroup = RetryUtil.retryOnFail(this::createLottoGroup, investmentMoney);
        printLottoGroup(lottoGroup);

        PrizeSummary prizeSummary = summarizePrizes(lottoGroup);
        printPrizeSummary(prizeSummary);
        printTotalProfitRate(prizeSummary, investmentMoney);
    }

    private InvestmentMoney createInvestmentMoney() {
        InvestmentMoneyDto investmentMoneyDto = RetryUtil.retryOnFail(inputView::readInvestmentMoney);
        int investmentMoney = investmentMoneyDto.getInvestmentMoney();
        return InvestmentMoney.from(investmentMoney);
    }

    private LottoGroup createLottoGroup(InvestmentMoney investmentMoney) {
        PurchasableLottoCount lottoCount = RetryUtil.retryOnFail(this::createLottoCount, investmentMoney);
        return LottoGroup.create(lottoCount, numberGenerator);
    }

    private PurchasableLottoCount createLottoCount(InvestmentMoney investmentMoney) {
        return investmentMoney.calculatePurchasableLottoCount(LottoPrice.STANDARD_PRICE);
    }

    private void printLottoGroup(LottoGroup lottoGroup) {
        LottoGroupDto lottoGroupDto = LottoGroupDto.from(lottoGroup);
        outputView.printLottoGroup(lottoGroupDto);
    }

    private PrizeSummary summarizePrizes(LottoGroup lottoGroup) {
        LottoMachine lottoMachine = createLottoMachine(lottoGroup);
        return lottoMachine.generatePrizeSummary();
    }

    private LottoMachine createLottoMachine(LottoGroup lottoGroup) {
        Lotto winningLotto = RetryUtil.retryOnFail(this::createWinningLotto);
        WinningCombination winningCombination = RetryUtil.retryOnFail(this::createWinningCombination, winningLotto);
        return LottoMachine.of(lottoGroup, winningCombination);
    }

    private Lotto createWinningLotto() {
        WinningLottoNumbersDto winningLottoNumbersDto = RetryUtil.retryOnFail(inputView::readWinningLottoNumbers);
        return Lotto.from(winningLottoNumbersDto.getWinningLottoNumbers());
    }

    private WinningCombination createWinningCombination(Lotto winningLotto) {
        LottoNumber bonusNumber = RetryUtil.retryOnFail(this::createBonusNumber);
        return WinningCombination.of(winningLotto, bonusNumber);
    }

    private LottoNumber createBonusNumber() {
        BonusNumberDto bonusNumberDto = RetryUtil.retryOnFail(inputView::readBonusNumber);
        return LottoNumber.from(bonusNumberDto.getBonusNumber());
    }

    private void printPrizeSummary(PrizeSummary prizeSummary) {
        outputView.printPrizeSummary(prizeSummary);
    }

    private void printTotalProfitRate(PrizeSummary prizeSummary, InvestmentMoney investmentMoney) {
        TotalProfitRate totalProfitRate = prizeSummary.calculateTotalProfitRate(investmentMoney);
        TotalProfitRateDto totalProfitRateDto = TotalProfitRateDto.from(totalProfitRate);
        outputView.printTotalProfitRate(totalProfitRateDto);
    }
}
