package lotto.domain;

public enum LottoIndexEnum {
    IS_UNDER_3RD(5),
    IS_2ND(6),
    IS_1ST(7);

    private final Integer LottoNum;

    LottoIndexEnum(int LottoNum) {
        this.LottoNum = LottoNum;
    }

    public Integer getLottoNum() {
        return LottoNum;
    }
}
