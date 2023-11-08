package lotto.io.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.MoneyValidator;

public class MoneyInput {
    public static int getMoney() {
        String money = Console.readLine();
        MoneyValidator.validate(money);
        return Integer.parseInt(money);
    }
}
