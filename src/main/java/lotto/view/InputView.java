package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

public class InputView {

    public static final String INPUT_MONEY_MSG = "구입금액을 입력해 주세요.";

    public int inputMoney() {
        System.out.println(INPUT_MONEY_MSG);
        String money = Console.readLine();
        Validator.getValidatedMoney(money);
        return Integer.parseInt(money);
    }
}
