package lotto.domain;

import lotto.view.InputView;

import java.util.List;

public class InputController {

    public static Money getMoney() {
        try {
            return new Money(InputView.inputLottoPurchaseMoney());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getMoney();
        }
    }

    public static WinningNumbers getWinningNumbers() {
        try {
            return new WinningNumbers(InputView.inputLottoWinningNumbers());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getWinningNumbers();
        }
    }

    public static BonusNumber getBonusNumber(List<Integer> winningNumber) {
        try {
            return new BonusNumber(winningNumber, InputView.inputLottoBonusNumber());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getBonusNumber(winningNumber);
        }
    }
}