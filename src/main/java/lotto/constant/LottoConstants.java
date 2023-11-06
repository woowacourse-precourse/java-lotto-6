package lotto.constant;

public enum LottoConstants {
    LOTTO_SIZE(6),          // 로또에 포함된 번호 개수
    LOTTO_MIN_NUMBER(1),    // 로또 번호 최소값
    LOTTO_MAX_NUMBER(45),   // 로또 번호 최대값
    LOTTO_PRICE(1000),      // 로또 가격
    MAX_LOTTO_PRICE_PER_USER(100_000), // 개인이 살 수 있는 로또 최대 금액

    /**
     * 1등이 '0' 이고, 꼴등이 '6'인 이유
     * 자바의 모든 매소드에서 함수를 실행할 때, 범위가 [Start, End) 이다.
     * 즉 0 ~ 5 이다.
     * 원소가 6개인 이유는, 1등부터 5등 그리고 NONE 값이 있다.
     */

    FIRST_RANKING(0),       // 로또 당첨 - 1등
    LAST_RANKING(6);        // 로또 당첨 - 꼴등 (6등, 꽝)

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
