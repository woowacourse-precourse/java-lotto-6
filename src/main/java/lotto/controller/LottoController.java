package lotto.controller;

import java.util.List;
import lotto.model.UserMoney;
import lotto.model.WinningNumbers;
import lotto.view.UserIoManager;

public class LottoController {
    private final UserIoManager userIoManager;

    public LottoController(UserIoManager userIoManager) {
        this.userIoManager = userIoManager;
    }

    public void run() {
        UserMoney userMoney = userIoManager.readUserMoney();
        List<Integer> numbers = userIoManager.readWinningNumbers();
        Integer bonusNumber = userIoManager.readBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusNumber);
    }
}
