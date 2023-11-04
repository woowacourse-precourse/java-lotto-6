package lotto.validator;

import java.util.regex.Pattern;

public class PaymentValidator {
    private static final Pattern MONEY_REGEX = Pattern.compile("^[0-9]*$");

    public static void validate(String input) {
        validateNumeric(input);
        validatePurchaseUnit(input);
    }

    private static void validateNumeric(String input) {
        if(!MONEY_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 금액 가격에 숫자가 아닌 정수는 입력할 수 없습니다.");
        }
    }

    private static void validatePurchaseUnit(String input) {
        if(Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로만 구매할 수 있습니다.");
        }
    }
}
