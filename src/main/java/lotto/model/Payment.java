package lotto.model;

import java.util.regex.Pattern;

public class Payment {
    private static final Pattern MONEY_REGEX = Pattern.compile("^[0-9]*$");
    private final int price;

    Payment(String input) {
        validate(input);
        this.price = Integer.parseInt(input);
    }

    private void validate(String input) {
        validateNumeric(input);
        validatePurchaseUnit(input);
    }

    private void validateNumeric(String input) {
        if(!MONEY_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 금액 가격에 숫자가 아닌 정수는 입력할 수 없습니다.");
        }
    }

    private void validatePurchaseUnit(String input) {
        if(Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로만 구매할 수 있습니다.");
        }
    }
}
