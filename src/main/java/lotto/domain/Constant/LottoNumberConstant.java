package lotto.domain.Constant;

public enum LottoNumberConstant {
    MIN(1),
    MAX(45),
    COUNT(6);

    private Integer value;

    private LottoNumberConstant(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}
