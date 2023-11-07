package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.bonus.BonusNumber;
import lotto.lotto.WinningLotto;
import lotto.money.Money;

public class InputView {

    public static Money getMoney() {
        return new Money(Console.readLine());
    }

    public static WinningLotto getWinnerLotto() {
        return new WinningLotto(Console.readLine());
    }

    public static BonusNumber getBonusNumber(WinningLotto winningLotto) {
        return BonusNumber.of(Console.readLine(), winningLotto);
    }
}
