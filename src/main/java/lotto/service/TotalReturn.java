package lotto.service;

import static lotto.type.LottoProperty.LOTTO_PRICE;

public class TotalReturn {
    private enum AWARD{
        FIRST(2000000000),
        SECOND(30000000),
        THIRD(1500000),
        FOURTH(50000),
        FIFTH(5000);

        private final int award;

        AWARD(int award) { this.award = award; }

        public int getAward() { return award; }
    }

    public static double getTotalReturnRate(int[] ranking, int amount) {
        int totalMoney = 0;
        totalMoney += ranking[7] * AWARD.FIRST.getAward();
        totalMoney += ranking[6] * AWARD.SECOND.getAward();
        totalMoney += ranking[5] * AWARD.THIRD.getAward();
        totalMoney += ranking[4] * AWARD.FOURTH.getAward();
        totalMoney += ranking[3] * AWARD.FIFTH.getAward();
        int spendMoney = amount * LOTTO_PRICE.getLottoProperty();
        return totalMoney * 1.0 * 100 / spendMoney;
    }
}
