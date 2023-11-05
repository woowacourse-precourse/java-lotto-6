package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Controller.Validator;

public class inputView {
    static final String GET_INPUT_PURCHASE_AMOUNT_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static int getInputPurchaseAmount() {
        System.out.println(GET_INPUT_PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();

        while (true) {
            try {
                if (Validator.validateInputIsNull(input)) {
                    throw new IllegalArgumentException("[ERROR] 입력 값은 널값이 될 수 없습니다.");
                }

                if (!Validator.validateInputIsNumeric(input)) {
                    throw new IllegalArgumentException("[ERROR] 입력 값은 숫자여야 합니다.");
                }

                if (!Validator.validateInputPurchaseAmount(input)) {
                    throw new IllegalArgumentException("[ERROR] 입력 값은 양수거나 1,000원 단위여야 합니다.");
                }

                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println(GET_INPUT_PURCHASE_AMOUNT_MESSAGE);
                input = Console.readLine();
            }
        }
    }


}
