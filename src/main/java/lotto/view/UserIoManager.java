package lotto.view;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.UserLotto;
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

    public Lotto readWinningNumbers() {
        while (true) {
            try {
                outputView.printWinningNumbersGuide();
                return inputView.readWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public Bonus readBonusNumber() {
        while (true) {
            try {
                outputView.printBonusNumberGuide();
                return new Bonus(inputView.readBonusNumber());
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void printLottoAmount(UserMoney userMoney) {
        outputView.printLottoAmount(userMoney);
    }

    public void printUserLotto(UserLotto userLotto) {
        outputView.printUserLotto(userLotto);
    }

    public void printResult(UserLotto userLotto, WinningNumbers winningNumbers) {
        outputView.printResultGuide();
        outputView.printHorizontalLine();
        outputView.printLottoRanks(userLotto, winningNumbers);
    }
}
