package lotto.view;

import java.util.List;
import lotto.model.UserMoney;
import lotto.model.WinningNumbers;

public class UserIoManager {
    private final InputView inputView;
    private final OutputView outputView;

    public UserIoManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public UserMoney readUserMoney() {
        while (true) {
            try {
                outputView.printUserMoneyInputGuide();
                int userMoney = inputView.readUserMoney();
                return new UserMoney(userMoney);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public WinningNumbers readWinningNumbersWithBonusNumber() {
        List<Integer> numbers = readWinningNumbers();
        Integer bonusNumber = readBonusNumber();
        return new WinningNumbers(numbers, bonusNumber);
    }

    private List<Integer> readWinningNumbers() {
        while (true) {
            try {
                outputView.printWinningNumbersGuide();
                return inputView.readWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private Integer readBonusNumber() {
        while (true) {
            try {
                outputView.printBonusNumberGuide();
                return inputView.readBonusNumber();
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
