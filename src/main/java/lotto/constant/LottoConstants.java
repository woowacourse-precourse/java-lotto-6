package lotto.constant;

public enum LottoConstants {
    LOTTO_SIZE(6),         // 로또 번호 개수
    LOTTO_MIN_NUMBER(1),   // 로또 번호 최소값
    LOTTO_MAX_NUMBER(45),  // 로또 번호 최대값
    LOTTO_PRICE(1000), // 로또 가격
    MAX_LOTTO_PRICE_PER_USER(1_000_000), // 개인이 살 수 있는 로또 최대 금액
    FIRST_RANKING(0),        // 1등
    LAST_RANKING(6);        // 꼴등 (6등, 꽝)

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
