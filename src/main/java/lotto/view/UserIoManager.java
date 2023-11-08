package lotto.view;

import lotto.model.lotto.Bonus;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningNumbers;
import lotto.model.user.UserLotto;
import lotto.model.user.UserLottoRank;
import lotto.model.user.UserMoney;

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
                printErrorMessage(e.getMessage());
            }
        }
    }

    public Lotto readWinningNumbers() {
        while (true) {
            try {
                outputView.printWinningNumbersGuide();
                return inputView.readWinningNumbers();
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    public WinningNumbers readBonusNumber(Lotto lotto) {
        while (true) {
            try {
                outputView.printBonusNumberGuide();
                Bonus bonus = new Bonus(inputView.readBonusNumber());
                return new WinningNumbers(lotto, bonus);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    public void printLottoAmount(UserMoney userMoney) {
        outputView.printLottoAmount(userMoney);
    }

    public void printUserLotto(UserLotto userLotto) {
        outputView.printUserLotto(userLotto);
    }

    public void printResult(UserMoney userMoney, UserLottoRank userLottoRank) {
        outputView.printResultGuide();
        outputView.printHorizontalLine();
        outputView.printUserLottoRank(userLottoRank);
        outputView.printRevenueRate(userMoney, userLottoRank);
    }

    private void printErrorMessage(String message) {
        System.out.println(message);
    }
}
