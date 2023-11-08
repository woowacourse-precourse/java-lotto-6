package lotto.model.constant;

public enum LottoResultConstants {
    PERCENTAGE_CARCULATOR(100);

    private final int number;

    LottoResultConstants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
