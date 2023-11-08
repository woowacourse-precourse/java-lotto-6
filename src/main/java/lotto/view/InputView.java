package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.bonus.BonusNumber;
import lotto.lotto.WinningLotto;
import lotto.money.LottoMoney;

public class InputView {

    public static LottoMoney getMoney() {
        return new LottoMoney(Console.readLine());
    }

    public static WinningLotto getWinnerLotto() {
        return new WinningLotto(Console.readLine());
    }

    public static BonusNumber getBonusNumber(WinningLotto winningLotto) {
        return BonusNumber.of(Console.readLine(), winningLotto);
    }
}
