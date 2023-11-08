package lotto.domain;

public enum LottoInfo {
    MAX_NUMBER(45),
    MIN_NUMBER(1),
    LOTTO_NUMBER_SIZE(6);

    private final Integer numberInfo;

    LottoInfo(Integer numberInfo) {
        this.numberInfo = numberInfo;
    }

    public Integer getNumberInfo() {
        return numberInfo;
    }
}
