package lotto.controller;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import lotto.dto.request.BonusNumberDto;
import lotto.dto.request.InvestmentMoneyDto;
import lotto.dto.request.WinningLottoNumbersDto;
import lotto.dto.response.LottoGroupDto;
import lotto.dto.response.PrizeSummaryDto;
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
        InvestmentMoney investmentMoney = getInvestmentMoneyFromUser();

        LottoGroup lottoGroup = generateLottoGroup(investmentMoney);
        printLottoGroup(lottoGroup);

        PrizeSummary prizeSummary = generatePrizeSummary(lottoGroup);
        printPrizeSummary(prizeSummary);

        TotalProfitRate totalProfitRate = generateTotalProfitRate(prizeSummary, investmentMoney);
        printTotalProfitRate(totalProfitRate);
    }

    private InvestmentMoney getInvestmentMoneyFromUser() {
        return retryOnException(this::createInvestmentMoney);
    }

    private InvestmentMoney createInvestmentMoney() {
        InvestmentMoneyDto investmentMoneyDto = retryOnException(inputView::readInvestmentMoney);
        int investmentMoney = investmentMoneyDto.getInvestmentMoney();
        return InvestmentMoney.from(investmentMoney);
    }

    private LottoGroup generateLottoGroup(InvestmentMoney investmentMoney) {
        return retryOnException(this::createLottoGroup, investmentMoney);
    }

    private LottoGroup createLottoGroup(InvestmentMoney investmentMoney) {
        PurchasableLottoCount lottoCount = retryOnException(this::calculatePurchasableLottoCount, investmentMoney);
        return LottoGroup.create(lottoCount, numberGenerator);
    }

    private PurchasableLottoCount calculatePurchasableLottoCount(InvestmentMoney investmentMoney) {
        return investmentMoney.calculatePurchasableLottoCount(LottoPrice.STANDARD_PRICE);
    }

    private void printLottoGroup(LottoGroup lottoGroup) {
        LottoGroupDto lottoGroupDto = LottoGroupDto.from(lottoGroup);
        outputView.printLottoGroup(lottoGroupDto);
    }

    private PrizeSummary generatePrizeSummary(LottoGroup lottoGroup) {
        LottoMachine lottoMachine = createLottoMachine(lottoGroup);
        return lottoMachine.generatePrizeSummary();
    }

    private LottoMachine createLottoMachine(LottoGroup lottoGroup) {
        Lotto winningLotto = retryOnException(this::createWinningLotto);
        WinningCombination winningCombination = retryOnException(this::createWinningCombination, winningLotto);
        return LottoMachine.of(lottoGroup, winningCombination);
    }

    private Lotto createWinningLotto() {
        WinningLottoNumbersDto winningLottoNumbersDto = retryOnException(inputView::readWinningLottoNumbers);
        List<Integer> winningLottoNumbers = winningLottoNumbersDto.getWinningLottoNumbers();
        return Lotto.from(winningLottoNumbers);
    }

    private WinningCombination createWinningCombination(Lotto winningLotto) {
        LottoNumber bonusNumber = retryOnException(this::createBonusNumber);
        return WinningCombination.of(winningLotto, bonusNumber);
    }

    private LottoNumber createBonusNumber() {
        BonusNumberDto bonusNumberDto = retryOnException(inputView::readBonusNumber);
        int bonusNumber = bonusNumberDto.getBonusNumber();
        return LottoNumber.from(bonusNumber);
    }

    private void printPrizeSummary(PrizeSummary prizeSummary) {
        PrizeSummaryDto prizeSummaryDto = PrizeSummaryDto.from(prizeSummary.getSummary());
        outputView.printPrizeSummary(prizeSummaryDto);
    }

    private static TotalProfitRate generateTotalProfitRate(PrizeSummary prizeSummary, InvestmentMoney investmentMoney) {
        return prizeSummary.generateTotalProfitRate(investmentMoney);
    }

    private void printTotalProfitRate(TotalProfitRate totalProfitRate) {
        TotalProfitRateDto totalProfitRateDto = TotalProfitRateDto.from(totalProfitRate);
        outputView.printTotalProfitRate(totalProfitRateDto);
    }

    private <T> T retryOnException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return retryOnException(supplier);
        }
    }

    private <T, R> R retryOnException(Function<T, R> function, T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return retryOnException(function, input);
        }
    }
}
