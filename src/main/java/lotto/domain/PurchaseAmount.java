package lotto.domain;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public PurchaseAmount(String amount) {
        verification(amount);
        this.amount = Integer.parseInt(amount);
    }

    public int getAmount() {
        return amount;
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    private void verification(String amount) {
        isNullPurchaseAmount(amount);
        isPurchaseAmount(amount);
        isValidPurchaseAmount(amount);
    }

    private void isNullPurchaseAmount(String amount) {
        if (amount.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 공백일 수 없습니다.\n");
        }
    }

    private void isPurchaseAmount(String amount) {
        if (amount.matches(".*[^0-9].*")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 입력할 수 있습니다.\n");
        }
    }

    private void isValidPurchaseAmount(String amount) {
        if (Integer.parseInt(amount) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 천원 단위로 입력할 수 있습니다.\n");
        }
    }
}