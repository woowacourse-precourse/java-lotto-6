package lotto.fixture;

import lotto.model.LottoNumber;
import lotto.model.WinningNumber;
import lotto.model.WinningNumbers;

public class WinningNumbersFixture {

    public static WinningNumbers createWinningNumbers(final String winningNumber, final String bonusNumber) {

        return new WinningNumbers(WinningNumber.createWith(winningNumber), LottoNumber.createWith(bonusNumber));
    }
}
