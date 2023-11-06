package lotto.model;

import java.util.regex.Pattern;

public class PurchaseLotto {

    private static final Pattern moneyPattern = Pattern.compile("^[0-9]*$");
    private static final int AMOUNT_UNIT = 1000;
    private static final int MINIMUM_AMOUNT = 1000;
    private static final int LOTTO_PRICE = 1000;
    private int purchaseAmount;
    private int numberOfPurchases;

    public void purchase(String input) {
        validateNumber(input);
        int money = Integer.parseInt(input);
        validateMinimumAmount(money);
        validateAmountUnit(money);
        this.purchaseAmount = money;
        this.numberOfPurchases = money / LOTTO_PRICE;
    }

    private static void validateAmountUnit(int money) {
        if (money % AMOUNT_UNIT > 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.");
        }
    }

    private static void validateMinimumAmount(int money) {
        if (money < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 최소 구매 금액은 1,000원 입니다.");
        }
    }

    private static void validateNumber(String money) {
        if (!moneyPattern.matcher(money).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
    }
}
