package lotto.domain.Constant;

public enum LottoCash {
    UNIT(1000),
    MATCH3(5000),
    MATCH4(50000),
    MATCH5(1500000),
    MATCH5ANDBONUS(30000000),
    MATCH6(2000000000);

    private Integer cash;

    private LottoCash(Integer cash) {
        this.cash = cash;
    }

    public Integer getCash() {
        return this.cash;
    }
}
