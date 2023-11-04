package lotto.model;

import java.util.regex.Pattern;

public class PurchaseLotto {

    private static final Pattern moneyPattern = Pattern.compile("^[0-9]*$");

    public void purchase(String input) {
        validateNumber(input);
        int money = Integer.parseInt(input);
        validateMinimumAmount(money);
    }

    private static void validateMinimumAmount(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 구매 금액은 1,000원 입니다.");
        }
    }

    private static void validateNumber(String money) {
        if (!moneyPattern.matcher(money).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
