package lotto.controller;

import lotto.model.Lotto;
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
        Lotto lotto = userIoManager.readWinningNumbers();
        Integer bonusNumber = userIoManager.readBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(lotto, bonusNumber);
    }
}
