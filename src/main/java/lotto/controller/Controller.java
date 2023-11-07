package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Money;
import lotto.utils.StringParser;
import lotto.view.BonusNumberInputView;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.PurchaseCostInputView;
import lotto.view.WinningNumberInputView;

public class Controller {
    private InputView inputView;

    private Money getMoney() {
        OutputView.printGetMoneyMessage();
        while (true) {
            try {
                inputView = new PurchaseCostInputView();
                return new Money(StringParser.parseStringToInt(inputView.getUserInput()));
            } catch (IllegalArgumentException e) {
                OutputView.printCommonString(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumber() {
        OutputView.printGetWinningNumberMessage();
        while (true) {
            try {
                inputView = new WinningNumberInputView();
                return StringParser.parseStringToIntList(inputView.getUserInput());
            } catch (IllegalArgumentException e) {
                OutputView.printCommonString(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber(List<Integer> winningNumbers) {
        OutputView.printGetBonusNumberMessage();
        while (true) {
            try {
                inputView = new BonusNumberInputView();
                int bonus = StringParser.parseStringToInt(inputView.getUserInput());
                return new BonusNumber(bonus, winningNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.printCommonString(e.getMessage());
            }
        }
    }
}
