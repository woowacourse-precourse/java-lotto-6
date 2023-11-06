package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constant.Number.THOUSAND;
import static lotto.constant.Number.ZERO;
import static lotto.constant.message.InputMessage.*;
import static lotto.constant.message.ErrorMessage.*;

public class InputMoneyView {
    private int money;

    public int inputMoney() {
        while (true) {
            try {
                System.out.println(MONEY_MESSAGE);
                money = Integer.parseInt(readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(NOT_INTEGER);
            } catch (IllegalArgumentException e) {
                illegalArgument();
            }
        }
        return money;
    }

    private void illegalArgument() {
        if (money < THOUSAND) {
            System.out.println(UNDER_THOUSAND);
        }
        if (money % THOUSAND != ZERO) {
            System.out.println(CANNOT_DIVIDE_BY_THOUSAND);
        }
    }
}
