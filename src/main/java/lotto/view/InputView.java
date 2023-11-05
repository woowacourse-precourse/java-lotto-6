package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.InputConvertor;
import lotto.utils.InputValidator;

public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static String getInput(String message) {
        System.out.println(message);
        try {
            return InputValidator.validate(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInput(message);
        }
    }

    public static int getMoneyInput() {
        try {
            return InputConvertor.convertMoney(getInput(MONEY_INPUT_MESSAGE));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoneyInput();
        }
    }

}
