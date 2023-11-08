package lotto.view;

import lotto.domain.Bonus;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

public interface Viewable {

    Money getMoneyInput();

    Bonus getBonusInput();

    WinningLotto getWinningInput();

}
