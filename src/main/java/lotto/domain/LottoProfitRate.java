package lotto.domain;

public class LottoProfitRate {
    private final double value;

    public LottoProfitRate(double value) {
        this.value = value;
    }

    public String getValueByString() {
        return String.format("%.1f", value);
    }
}
