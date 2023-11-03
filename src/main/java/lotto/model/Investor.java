package lotto.model;

public class Investor {

    private final Money investMoney;
    private final Money profitMoney;

    private Investor(final Money investMoney, final Money profitMoney) {
        this.investMoney = investMoney;
        this.profitMoney = profitMoney;
    }

    public static Investor createDefault(final Money investMoney) {
        Money profitMoney = Money.createDefault();
        return new Investor(investMoney, profitMoney);
    }
}
