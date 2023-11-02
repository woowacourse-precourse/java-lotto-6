package lotto.domain;

public enum LottoNumbers {

    LOTTO_SIZE(6),

    MIN_LOTTO_NUMBER(1),

    MAX_LOTTO_NUMBER(45);

    private final int number;

    LottoNumbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
