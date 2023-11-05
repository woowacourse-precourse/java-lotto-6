package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;

public class InputView {

    private InputView() {
    }

    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER_INPUT.getMessage());
        }
    }
}
