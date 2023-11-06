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
        outputView.printUserMoneyInputGuide();
        int userMoney = inputView.readUserMoney();
        return new UserMoney(userMoney);
    }

    public WinningNumbers readWinningNumbersWithBonusNumber() {
        outputView.printWinningNumbersGuide();
        List<Integer> numbers = inputView.readWinningNumbers();
        outputView.printBonusNumberGuide();
        Integer bonusNumber = inputView.readBonusNumber();
        return new WinningNumbers(numbers, bonusNumber);
    }
}
