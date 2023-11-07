package lotto.InputView;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.validator.Validator;

public class InputView {
    private static Validator validator = new Validator();
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public static Integer getAmount() {
        int amount = getAmountFromUser();
        validator.validateAmount(amount);
        return amount;
    }
    public static Integer getAmountFromUser() {
        System.out.println(MONEY_INPUT_MESSAGE);
        return Integer.valueOf(Console.readLine());
    }
}
