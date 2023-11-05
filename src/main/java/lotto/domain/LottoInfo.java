package lotto.domain;

public enum LottoInfo {
    MAX_NUMBER(45),
    MIN_NUMBER(1),
    MAX_SIZE(6);

    private final int numberInfo;

    LottoInfo(int numberInfo) {
        this.numberInfo = numberInfo;
    }

    public int getNumberInfo() {
        return numberInfo;
    }
}
