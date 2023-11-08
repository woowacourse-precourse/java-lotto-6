package lotto.controller;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.UserLotto;
import lotto.model.UserLottoRank;
import lotto.model.UserMoney;
import lotto.model.WinningNumbers;
import lotto.util.generator.NumberGenerator;
import lotto.view.UserIoManager;

public class LottoController {
    private final UserIoManager userIoManager;
    private final NumberGenerator numberGenerator;

    public LottoController(UserIoManager userIoManager, NumberGenerator numberGenerator) {
        this.userIoManager = userIoManager;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        UserMoney userMoney = userIoManager.readUserMoney();
        userIoManager.printLottoAmount(userMoney);
        UserLotto userLotto = new UserLotto(userMoney.getLottoAmount(), numberGenerator);
        userIoManager.printUserLotto(userLotto);
        Lotto lotto = userIoManager.readWinningNumbers();
        Bonus bonus = userIoManager.readBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(lotto, bonus);
        UserLottoRank userLottoRank = new UserLottoRank(userLotto, winningNumbers);
        userIoManager.printResult(userMoney, userLottoRank);
    }
}
