package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Controller.Validator;

public class inputView {
    static final String GET_INPUT_PURCHASE_AMOUNT_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static int getInputPurchaseAmount() {
        System.out.println(GET_INPUT_PURCHASE_AMOUNT_MESSAGE);

        while (true) {
            String input = Console.readLine();
            try {
                int amount = Validator.validatePurchaseAmount(input);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getInputBonusNumber() {
        System.out.println(GET_INPUT_PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();
        while(true){
            try {
                int number = Validator.validateBonusNumber(input);
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println(GET_INPUT_PURCHASE_AMOUNT_MESSAGE);
                input = Console.readLine();
            }
        }
    }


}
