package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.util.LottoGuideMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        Money money = repeatUntilValidMoneyCreated();
        WinningNumbers winningNumbers = repeatUntilValidWinningNumbersCreated();
        repeatUntilValidBonusNumberAssigned(winningNumbers);
    }

    private void repeatUntilValidBonusNumberAssigned(WinningNumbers winningNumbers) {
        while (true) {
            try {
                assignBonusNumberToWinningNumbers(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                outputView.showMessage(e.getMessage());
            }
        }
    }

    private void assignBonusNumberToWinningNumbers(WinningNumbers winningNumbers) {
        String userInput = inputWithMessage(LottoGuideMessage.ENTER_BONUS_NUMBER);
        winningNumbers.setBonusNumber(new BonusNumber(userInput));
    }

    private WinningNumbers repeatUntilValidWinningNumbersCreated() {
        while (true) {
            try {
                return createWinningNumbersFromUserInput();
            } catch (IllegalArgumentException e) {
                outputView.showMessage(e.getMessage());
            }
        }
    }

    private WinningNumbers createWinningNumbersFromUserInput() {
        String userInput = inputWithMessage(LottoGuideMessage.ENTER_WINNING_NUMBER);
        return new WinningNumbers(userInput);
    }

    private Money repeatUntilValidMoneyCreated() {
        while (true) {
            try {
                return createMoneyFromUserInput();
            } catch (IllegalArgumentException e) {
                outputView.showMessage(e.getMessage());
            }
        }
    }

    private Money createMoneyFromUserInput() {
        String userInput = inputWithMessage(LottoGuideMessage.ENTER_PURCHASE_AMOUNT);
        return new Money(userInput);
    }

    private String inputWithMessage(LottoGuideMessage lottoGuideMessage) {
        outputView.showMessage(lottoGuideMessage.getMessage());
        return inputView.getUserInput();
    }
}
