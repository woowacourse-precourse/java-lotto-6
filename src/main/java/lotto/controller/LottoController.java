package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.LottoTicket;
import lotto.model.ResultDetails;
import lotto.model.WinningNumbers;
import lotto.model.WinningNumbersData;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final ResultDetails resultDetails = new ResultDetails();

    public void play() {
        int purchaseAmount = generateValidMoney();

        LottoTicket lottoTicket = LottoTicket.generate(purchaseAmount / 1000);

        OutputView.printNumberOfLotto(purchaseAmount / 1000);
        OutputView.printLottoTicket(lottoTicket);

        WinningNumbers winningNumbers = createValidWinningNumbers();

        resultDetails.updateWinningResults(lottoTicket, winningNumbers);

        OutputView.printWinningStatisticsHeader();
        OutputView.printWinningStatistics(resultDetails);
        OutputView.printProfitRate(resultDetails.calculateProfitRate(purchaseAmount));
    }

    private int generateValidMoney() {
        while (true) {
            try {
                OutputView.printPurchaseAmountMessage();
                int purchaseAmount = InputView.inputNumber();
                validateMoney(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumbers createValidWinningNumbers() {
        WinningNumbersData winningNumbersData = createValidWinningNumbersData();
        while (true) {
            try {
                BonusNumber bonusNumber = createValidBonusNumber();
                return new WinningNumbers(winningNumbersData, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumbersData createValidWinningNumbersData() {
        while (true) {
            try {
                OutputView.printWinningNumbersMessage();
                List<Integer> winningNumbers = InputView.inputWinningNumbers();
                return new WinningNumbersData(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber createValidBonusNumber() {
        while (true) {
            try {
                OutputView.printBonusNumberMessage();
                int bonus = InputView.inputNumber();
                return new BonusNumber(bonus);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000원 단위여야 합니다.");
        }
    }
}
