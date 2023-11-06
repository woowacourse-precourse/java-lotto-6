package lotto.constant;

public enum LottoConstant {
    INIT_BUILDER_SIZE(0),
    REPLACE_SIZE(2),
    LOTTO_LENGTH(6),
    RANGE_START_NUMBER(1),
    RANGE_END_NUMBER(45);

    private final Integer setting;

    LottoConstant(Integer setting) {
        this.setting = setting;
    }

    public Integer getSetting() {
        return setting;
    }
}
