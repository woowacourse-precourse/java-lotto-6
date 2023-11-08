package lotto.model;

public enum LottoPrice {
    STANDARD_PRICE(1_000);

    private static final String MINIMUM_PURCHASE_PRICE_EXCEPTION_FORMAT = "로또 구입 금액은 최소 %,d원 이상이어야 합니다.";
    private static final String INDIVISIBLE_AMOUNT_EXCEPTION_FORMAT = "로또 구입 금액은 %,d원 단위로 입력해야 합니다.";
    private static final int ZERO = 0;

    private final int price;

    LottoPrice(int price) {
        this.price = price;
    }

    public void validateMinimumPurchasePrice(int money) {
        if (price > money) {
            String exceptionMessage = String.format(MINIMUM_PURCHASE_PRICE_EXCEPTION_FORMAT, price);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public PurchasableLottoCount createPurchasableLottoCount(InvestmentMoney investMoney) {
        int count = calculateLottoCount(investMoney);

        return PurchasableLottoCount.from(count);
    }

    private int calculateLottoCount(InvestmentMoney investMoney) {
        int money = investMoney.getMoney();

        return money / price;
    }

    public void validateDivisible(int investMoney) {
        if (!isDivisible(investMoney)) {
            String exceptionMessage = String.format(INDIVISIBLE_AMOUNT_EXCEPTION_FORMAT, price);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private boolean isDivisible(int investMoney) {
        return investMoney % price == ZERO;
    }
}
