package lotto.domain;

public enum LottoInfo {
    START(1),
    END(45),
    LENGTH(6),
    PRISE(1000);

    final int value;

    LottoInfo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
