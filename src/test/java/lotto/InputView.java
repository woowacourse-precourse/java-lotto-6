package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.exception.InvalidSizeException;
import lotto.exception.NonNumericAmountException;

public class InputView {

    public static int readMoney() {
        String money = Console.readLine();

        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new NonNumericAmountException();
        }
    }
}

