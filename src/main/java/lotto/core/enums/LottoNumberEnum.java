package lotto.core.enums;

public enum LottoNumberEnum {
    START_VALUE(1),
    END_VALUE(45),
    SIZE(6);

    private final Integer value;

    LottoNumberEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}
