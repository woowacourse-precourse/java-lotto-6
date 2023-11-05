package lotto.domain.proxy;

import java.text.DecimalFormat;

public class PrizeAmount {
    private final int amount;

    private PrizeAmount(int amount) {
        this.amount = amount;
    }

    public static PrizeAmount of(int amount) {
        return new PrizeAmount(amount);
    }

    public int getAmount() {
        return amount;
    }

    /**
     * 3자리 수 이상일 경우 콤마(,)를 추가해 반환
     * ex) 1,000,000
     */
    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(amount);
    }
}
