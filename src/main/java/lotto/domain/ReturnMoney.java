package lotto.domain;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.util.MatchRanking;

public class ReturnMoney {

    private final double returnMoney;
    private static String SECOND_DECIMAL_PLACE = "#.##";
    private static double PERCENTAGE = 100.0;

    public ReturnMoney(Map<MatchRanking, Integer> rankingCount, LottoPrice lottoPrice) {
        returnMoney = findReturnMoney(rankingCount, lottoPrice);
    }

    public double getReturnMoney() {
        return returnMoney;
    }

    private double findReturnMoney(Map<MatchRanking, Integer> rankingCount, LottoPrice lottoPrice) {
        int getTotalMoney = 0;
        int purchaseAmount = lottoPrice.getLottoPrice();

        for (MatchRanking key : rankingCount.keySet()) {
            getTotalMoney += key.getMoney() * rankingCount.get(key);
        }

        DecimalFormat decimalFormat = new DecimalFormat(SECOND_DECIMAL_PLACE);
        double returnMoney = getTotalMoney / (double)purchaseAmount * PERCENTAGE;
        return Double.parseDouble(decimalFormat.format(returnMoney));
    }
}
