package lotto.enums;

public enum LottoNumbers {
    MIN_RANGE(1),
    MAX_RANGE(45);

    private final int number;

    private LottoNumbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
