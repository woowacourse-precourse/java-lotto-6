package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.UserAmount;

public class InputView {

    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static UserAmount getUserAmount() {
        String input = input(INPUT_PURCHASE_PRICE_MESSAGE);
        try {
            UserAmount userAmount = UserAmount.from(input);
            return userAmount;
        } catch (IllegalArgumentException ex) {
            OutputView.printError(ex.getMessage());
            return getUserAmount();
        }
    }

    public static String input(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
