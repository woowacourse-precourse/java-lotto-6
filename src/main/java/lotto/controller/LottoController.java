package lotto.controller;

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
        WinningNumbers winningNumbers = userIoManager.readWinningNumbersWithBonusNumber();
    }
}
