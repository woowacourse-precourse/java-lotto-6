package lotto.domain.model;

public enum LottoPrice {
    LOTTO_PRICE(1000),
    MATCH_3_PRICE(5_000),
    MATCH_4_PRICE(50_000),
    MATCH_5_PRICE(1_500_000),
    MATCH_5_WITH_BONUS_PRICE(30_000_000),
    MATCH_6_PRICE(2_000_000_000);

    private final int value;

    LottoPrice(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
