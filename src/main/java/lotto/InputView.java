package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputPurchase() {
        String rawPurchase = input("구입금액을 입력해 주세요.");
        validateNumber(rawPurchase);
        return rawPurchase;
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
