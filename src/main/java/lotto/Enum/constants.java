package lotto.Enum;

public enum constants {
    MAX_LOTTO_NUMBER(45),
    MIN_LOTTO_NUMBER(1),
    LOTTO_NUMBER_COUNT(6),
    MIN_PRIZE_CORRECT_COUNT(3);

    int number;

    constants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
