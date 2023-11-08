package lotto.entity;

public enum Prize {

    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    FIVEANDBONUS(30000000),
    SIX(2000000000);

    private final Integer amount;

    Prize(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }
}
