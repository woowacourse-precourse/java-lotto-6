package lotto.constant;

public enum CashConstant {
    UNIT(1000),
    INIT_SPEND_AMOUNT(0);

    private final Integer setting;

    CashConstant(Integer setting) {
        this.setting = setting;
    }

    public Integer getSetting() {
        return setting;
    }
}