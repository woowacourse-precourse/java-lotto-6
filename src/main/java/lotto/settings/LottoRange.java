package lotto.settings;

public enum LottoRange {

    MIN_VALUE(1),
    MAX_VALUE(45);

    private final int number;

    LottoRange(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
