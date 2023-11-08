package lotto.Util;

public enum LottoEnum {
    // 당첨 등수
    FIRST(0),
    SECOND(1),
    THIRD(2),
     FOURTH(3),
     FIFTH(4),
     LOSE(-1),
    // 당첨 금액
     LOTTO_PRICE(1000),
     FIRST_PRIZE(2000000000),
     SECOND_PRIZE(30000000),
     THIRD_PRIZE(1500000),
     FOURTH_PRIZE(50000),
     FIFTH_PRIZE(5000);

    private final int value;
    LottoEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
