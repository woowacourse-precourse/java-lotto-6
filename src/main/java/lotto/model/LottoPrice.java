package lotto.model;

public enum LottoPrice {
    STANDARD_PRICE(1_000);

    private static final String EXCEPTION_FORMAT = "로또 구입 금액은 %d원 단위로 입력해야 합니다.";
    private static final int NO_REMAINDER = 0;

    private final int price;

    LottoPrice(int price) {
        this.price = price;
    }

    public void validateDivisibility(int userMoney) {
        if (isNotDivisible(userMoney)) {
            String formattedExceptionMessage = String.format(EXCEPTION_FORMAT, price);
            throw new IllegalArgumentException(formattedExceptionMessage);
        }
    }

    private boolean isNotDivisible(int userMoney) {
        return userMoney % price != NO_REMAINDER;
    }

    public int multiply(int count) {
        return price * count;
    }

    public int calculateLottoCount(UserMoney userMoney) {
        return userMoney.calculateLottoPurchaseCount(price);
    }
}
