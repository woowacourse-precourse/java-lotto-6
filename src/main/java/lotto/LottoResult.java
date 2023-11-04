package lotto;

public enum LottoResult {
    NOTING(0),
    FIFTH_PRIZE(5000),
    FOURTH_PRIZE(50000),
    THIRD_PRIZE(1500000),
    SECOND_PRIZE(30000000),
    FIRST_PRIZE(2000000000);

    private final int price;

    LottoResult(int price) {
        this.price = price;
    }
}
