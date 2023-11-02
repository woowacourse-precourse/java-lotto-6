package lotto.domain.lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PurchasePrice {
    private static final Pattern priceRegex = Pattern.compile("^[0-9]+(,*\\d)*$");

    private final int price;

    public PurchasePrice(String purchasePrice) {
        validate(purchasePrice);
        this.price = Integer.parseInt(purchasePrice);
    }

    public int getPrice() {
        return price;
    }

    private void validate(String purchasePrice) {
        validateFormat(purchasePrice);

        int numberOfPrice = parsePrice(purchasePrice);
        validateNotBelowOptimalPrice(numberOfPrice);
        validateDivisibleByProperAmount(numberOfPrice);
    }

    private int parsePrice(String purchasePrice) {
        return Integer.parseInt(purchasePrice.replaceAll(",", ""));
    }

    private void validateFormat(String purchasePrice) {
        Matcher matcher = priceRegex.matcher(purchasePrice);
        boolean isNotMatch = !matcher.matches();

        if (isNotMatch) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자와 ,외에 다른 문자를 입력할 수 없습니다.");
        }
    }

    private void validateNotBelowOptimalPrice(int numberOfPrice) {
        if (numberOfPrice < 1000) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 이상이어야 합니다.");
        }
    }

    private void validateDivisibleByProperAmount(int numberOfPrice) {
        if (numberOfPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 단위여야 합니다.");
        }
    }
}
