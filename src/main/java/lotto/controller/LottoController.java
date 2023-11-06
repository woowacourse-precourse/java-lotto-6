package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;

public class LottoController {
    InputView inputView = new InputView();
    public void receiveUserInput() {
        receiveUserMoney();
        receiveUserBonusNumber(receiveUserStandardNumber());
    }

    private Money receiveUserMoney() {
        try {
            return new Money(inputView.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return receiveUserMoney();
    }

    private Lotto receiveUserStandardNumber() {
        try {
            return new Lotto(inputView.inputWinningLottoStandardNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return receiveUserStandardNumber();
    }

    private WinningLotto receiveUserBonusNumber(Lotto lotto) {
        try {
            return new WinningLotto(lotto, inputView.inputWinningLottoBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return receiveUserBonusNumber(lotto);
    }
}
