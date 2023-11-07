package lotto.global.view.io;

import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.WinningNormalNumbers;
import lotto.domain.lotto.WinningNumber;
import lotto.domain.lotto.WinningNumbers;
import lotto.domain.money.Money;

public interface InputProcessor {

    Money inputMoney();

    WinningNumbers inputWinningNormalNumbers();

    WinningNumbers inputBonusNumber();

    WinningNumbers inputWinningNumbers();
}
