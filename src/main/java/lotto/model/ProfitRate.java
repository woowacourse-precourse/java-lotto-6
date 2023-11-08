package lotto.model;

public class ProfitRate {
    private int[] value;
    private String money;

    public ProfitRate(int[] value, String money) {
        this.value = value;
        this.money = money;
    }

    public double calculate() {
        return profitRate(this.value, this.money);
    }

    public double profitRate(int[] value, String money) {
        long totalReward = (5000L * value[0]) + (50000L * value[1]) + (1500000L * value[2]) + (30000000L * value[3]) + (200000000L * value[4]);
        double profitRate = totalReward / Double.parseDouble(money);
        return profitRate;
    }
}
