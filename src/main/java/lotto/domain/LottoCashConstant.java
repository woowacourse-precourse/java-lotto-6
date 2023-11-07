package lotto.domain;

public enum LottoCashConstant {
    match3(5000),
    match4(50000),
    match5(1500000),
    match5AndBonus(30000000),
    match6(2000000000);

    private Integer cash;

    private LottoCashConstant(Integer cash) {
        this.cash = cash;
    }

    public Integer getCash() {
        return this.cash;
    }
}
