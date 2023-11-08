package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.User;
import lotto.domain.WinningNumber;
import lotto.utils.InputValidator;

public class InputView {
    public static User readPayment() {
        try {
            String pay = Console.readLine();
            InputValidator.validatePayNumber(pay);
            return User.paid(pay);
        } catch (IllegalArgumentException e) {
            return readPayment();
        }
    }

    public static WinningNumber readWinningNumber() {
        try {
            String winningNumber = Console.readLine();
            InputValidator.validateWinningNumber(winningNumber);
            return WinningNumber.consistOf(winningNumber);
        } catch (IllegalArgumentException e) {
            return readWinningNumber();
        }
    }

    public static BonusNumber readBonusNumber(WinningNumber winningNumber) {
        try {
            String bonusNumber = Console.readLine();
            InputValidator.validateBonusNumber(bonusNumber, winningNumber);
            return BonusNumber.consistOf(bonusNumber);
        } catch (IllegalArgumentException e) {
            return readBonusNumber(winningNumber);
        }
    }
}
