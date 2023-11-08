package lotto;

import static lotto.LottoProperty.LOTTO_PRICE;

public class TotalReturn {
    private static final int FIRST_AWARD = 2000000000;
    private static final int SECOND_AWARD = 30000000;
    private static final int THIRD_AWARD = 1500000;
    private static final int FOURTH_AWARD = 50000;
    private static final int FIFTH_AWARD = 5000;

    public static double getTotalReturnRate(int[] ranking, int amount) {
        int totalMoney = 0;
        totalMoney += ranking[7] * FIRST_AWARD;
        totalMoney += ranking[6] * SECOND_AWARD;
        totalMoney += ranking[5] * THIRD_AWARD;
        totalMoney += ranking[4] * FOURTH_AWARD;
        totalMoney += ranking[3] * FIFTH_AWARD;
        int spendMoney = amount * LOTTO_PRICE.getLottoProperty();
        return totalMoney * 1.0 / spendMoney;
    }
}
