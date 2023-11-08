package lotto.controller;

import static lotto.config.LottoConfig.PURCHASE_DIVISIBLE_AMOUNT;

import java.util.HashSet;
import java.util.List;
import lotto.config.LottoServices;
import lotto.config.LottoValidators;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;
import lotto.dto.LottoResultDto;
import lotto.dto.WinningLottoDto;
import lotto.validator.BonusNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController{
    private final LottoServices services;
    private final LottoValidators validators;
    private int purchaseAmount;
    private int dividedPurchaseAmount;
    private HashSet<PurchasedLotto> purchasedLotto;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private LottoResultDto lottoResultDto;

    public LottoController(LottoServices services, LottoValidators validators) {
        this.services = services;
        this.validators = validators;
    }

    public void run() {
        setPurchaseAmount();
        printPurchasedLottoAmount();
        purchaseLotto();
        setWinningNumbers();
        setBonusNumber();
        compare();
        printLottoResult();
    }

    private void setPurchaseAmount() {
        purchaseAmount = services.lottoSettingService.selectPurchaseAmount(validators.purchaseAmountValidator, InputView::getUserInput,
                OutputView::printPurchaseAmountRequestMessage,  OutputView::printErrorMessage);
    }

    private void printPurchasedLottoAmount() {
        dividePurchaseAmount();
        OutputView.printPurchasedAmountResultMessage(dividedPurchaseAmount);
    }

    private void purchaseLotto() {
        purchasedLotto = services.lottoPurchaseService.purchase(dividedPurchaseAmount);
        printPurchasedLotto(purchasedLotto);
    }

    private void printPurchasedLotto(HashSet<PurchasedLotto> purchasedLotto) {
        for (PurchasedLotto lotto : purchasedLotto) {
            OutputView.printPurchasedLotto(lotto.getNumbers());
        }
    }

    private void setWinningNumbers() {
        winningNumbers = services.lottoSettingService.selectWinningNumbers(validators.winningLottoValidator, InputView::getUserInput,
                OutputView::printWinningNumberRequestMessage,  OutputView::printErrorMessage);
    }

    private void setBonusNumber() {
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator(winningNumbers);
        bonusNumber = services.lottoSettingService.selectBonusNumber(bonusNumberValidator, InputView::getUserInput,
                OutputView::printBonusNumberRequestMessage,  OutputView::printErrorMessage);
    }

    private void compare() {
        WinningLotto winningLotto = services.lottoService.createWinningLotto(winningNumbers, bonusNumber);
        WinningLottoDto winningLottoDto = winningLotto.toDto();

        services.lottoService.compareNumbers(winningLotto, purchasedLotto);
        lottoResultDto = services.lottoResultService.generateLottoResult(purchasedLotto, winningLottoDto, purchaseAmount);
    }

    private void printLottoResult() {
        OutputView.printWinningStatistics(lottoResultDto.fifthPrizeCount(), lottoResultDto.fourthPrizeCount(),
                lottoResultDto.thirdPrizeCount(), lottoResultDto.secondPrizeCount(),
                lottoResultDto.firstPrizeCount(), lottoResultDto.profitRate());
    }

    private void dividePurchaseAmount() {
        dividedPurchaseAmount = purchaseAmount / PURCHASE_DIVISIBLE_AMOUNT.getValue();
    }

}
