package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.User;
import lotto.domain.WinningNumber;

public class InputView {
    public static User readPayment() {
        String pay = Console.readLine();
        return User.paid(pay);
    }

    public static WinningNumber readWinningNumber() {
        String winningNumber = Console.readLine();
        return WinningNumber.consistOf(winningNumber);
    }
}
