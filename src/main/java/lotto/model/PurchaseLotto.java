package lotto.model;

import java.util.regex.Pattern;

public class PurchaseLotto {

    private static final Pattern moneyPattern = Pattern.compile("^[0-9]*$");

    public void purchase(String money) {
        if (!moneyPattern.matcher(money).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
