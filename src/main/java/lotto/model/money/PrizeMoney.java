package lotto.model.money;

public class PrizeMoney {
    private static final int LOTTO_WINNING_DEFAULT_VALUE = 0;

    private Money totalPrizeMoney;

    public PrizeMoney() {
        this.totalPrizeMoney = Money.of(LOTTO_WINNING_DEFAULT_VALUE);
    }

    public void addMoney(int amount) {
        totalPrizeMoney.addMoney(amount);
    }

    public float getProfitRateInfo(Money userMoney) {
        return (float) totalPrizeMoney.getMoney() / userMoney.getMoney() * 100;
    }
}
