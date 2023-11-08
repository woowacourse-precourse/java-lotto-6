package lotto.controller;

import lotto.model.lotto.Bonus;
import lotto.model.lotto.Lotto;
import lotto.model.user.UserLotto;
import lotto.model.user.UserLottoRank;
import lotto.model.user.UserMoney;
import lotto.model.lotto.WinningNumbers;
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
        UserMoney userMoney = readMoney();

        UserLotto userLotto = generateUserLotto(userMoney);

        WinningNumbers winningNumbers = readWinningNumbers();

        printResult(userMoney, userLotto, winningNumbers);
    }

    private UserMoney readMoney() {
        UserMoney userMoney = userIoManager.readUserMoney();
        return userMoney;
    }

    private UserLotto generateUserLotto(UserMoney userMoney) {
        userIoManager.printLottoAmount(userMoney);
        UserLotto userLotto = new UserLotto(userMoney.getLottoAmount(), numberGenerator);
        userIoManager.printUserLotto(userLotto);
        return userLotto;
    }

    private WinningNumbers readWinningNumbers() {
        Lotto lotto = userIoManager.readWinningNumbers();
        return userIoManager.readBonusNumber(lotto);
    }

    private void printResult(UserMoney userMoney, UserLotto userLotto, WinningNumbers winningNumbers) {
        UserLottoRank userLottoRank = new UserLottoRank(userLotto, winningNumbers);
        userIoManager.printResult(userMoney, userLottoRank);
    }
}
