package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.validator.Validator;
import lotto.util.validator.ValidatorFactory;

public class InputView {
    public static int inputPurchase() {
        String rawPurchase = input("구입금액을 입력해 주세요.");
        validateNumber(rawPurchase);
        return Integer.parseInt(rawPurchase);
    }

    private static void validateNumber(String value) {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator validator = validatorFactory.getValidator(InputView.class);
        validator.validate(value);
    }

    private static String input(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private InputView() {
    }
}
