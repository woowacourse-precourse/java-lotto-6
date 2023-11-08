package lotto.domain.Constant;

public enum LottoNumber {
    MIN(1),
    MAX(45),
    COUNT(6);

    private Integer value;

    private LottoNumber(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}
