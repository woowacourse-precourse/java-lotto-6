package lotto.lotto;

enum LottoResult {
    PARTICIPATION_PRIZE(0, ""),
    FIFTH_PRIZE(5000, "3개 일치 (5,000원)"),
    FOURTH_PRIZE(50000, "4개 일치 (50,000원)"),
    THIRD_PRIZE(1500000, "5개 일치 (1,500,000원)"),
    SECOND_PRIZE(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST_PRIZE(2000000000, "6개 일치 (2,000,000,000원)");

    private final int price;
    private final String description;

    LottoResult(int price, String description) {
        this.price = price;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return description;
    }
}

