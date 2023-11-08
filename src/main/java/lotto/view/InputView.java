package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

public class InputView {

    public static String inputMoney() {
        String money = Console.readLine();
        Validator.validateMoney(money);
        return money;
    }
}
