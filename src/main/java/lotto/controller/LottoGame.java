package lotto.controller;

import java.util.List;
import lotto.model.Constants;
import lotto.model.Lotto;
import lotto.service.LottoGenerator;
import lotto.service.LottoProfitCalculator;
import lotto.service.LottoResultCalculator;
import lotto.util.InputParser;
import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private int purchaseAmount;
    private List<Lotto> lottoTickets;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void startLottoGame() {
        purchaseLotto();
        inputWinningAndBonusNumbers();
        finalizeLottoGame();
    }

    private void purchaseLotto() {
        purchaseAmount = getPurchaseAmount();
        int lottoTicketCount = purchaseAmount / Constants.LOTTO_PRICE;

        OutputView.printLottoBuy(lottoTicketCount);
        lottoTickets = LottoGenerator.generateLottoTickets(lottoTicketCount);
        OutputView.printAllLottoNumber(lottoTickets);
    }

    private void inputWinningAndBonusNumbers() {
        winningNumbers = getWinningNumbers();
        bonusNumber = getBonusNumber();
    }

    private void finalizeLottoGame() {
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningNumbers, bonusNumber);
        List<Integer> lottoResult = lottoResultCalculator.getLottoResult(lottoTickets);
        OutputView.printLottoResult(lottoResult);

        double profit = LottoProfitCalculator.calculateLottoProfit(purchaseAmount, lottoResult);
        OutputView.printProfitRate(profit);
    }

    private int getPurchaseAmount() {
        Integer purchaseAmount = getPurchaseAmountAttempt();

        while (purchaseAmount == null) {
            purchaseAmount = getPurchaseAmountAttempt();
        }
        return purchaseAmount;
    }

    private List<Integer> getWinningNumbers() {
        List<Integer> undividedWinningNumbers = getWinningNumbersAttempt();

        while (undividedWinningNumbers == null) {
            undividedWinningNumbers = getWinningNumbersAttempt();
        }
        return undividedWinningNumbers;
    }

    private int getBonusNumber() {
        Integer bonusNumber = getBonusNumberAttempt();

        while (bonusNumber == null) {
            bonusNumber = getBonusNumberAttempt();
        }
        return bonusNumber;
    }

    private static Integer getPurchaseAmountAttempt() {
        try {
            String purchaseAmount = InputView.inputPurchaseAmount();
            InputValidator.validatePurchaseAmount(purchaseAmount);
            return InputParser.parsePurchaseAmount(purchaseAmount);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printErrorMessage(illegalArgumentException.getMessage());
        }
        return null;
    }

    private static List<Integer> getWinningNumbersAttempt() {
        try {
            String undividedWinningNumbers = InputView.inputWinningNumbers();
            InputValidator.validateWinningNumbers(undividedWinningNumbers);
            return InputParser.parseWinningNumbers(undividedWinningNumbers);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printErrorMessage(illegalArgumentException.getMessage());
        }
        return null;
    }

    private Integer getBonusNumberAttempt() {
        try {
            String bonusNumber = InputView.inputBonusNumber();
            InputValidator.validateBonusNumber(winningNumbers, bonusNumber);
            return InputParser.parseBonusNumber(bonusNumber);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printErrorMessage(illegalArgumentException.getMessage());
        }
        return null;
    }

}