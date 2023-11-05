package lotto.model;

public class TotalProfitCalculator {
    private static final double SECOND_DECIMAL_NUMBER = 10.0;
    private final double totalProfit;
    private final int payment;

    public TotalProfitCalculator(LottoStatistics lottoStatistics, int payment) {
        this.totalProfit = calculateTotalProfit(lottoStatistics);
        this.payment = payment;
    }

    public double calculateTotalProfit(LottoStatistics lottoStatistics) {
        double allProfitMoney = calculateAllMoney(lottoStatistics);

        double decimal = allProfitMoney / (double) payment;
        return roundToTwoDecimal(decimal);
    }

    private double calculateAllMoney(LottoStatistics lottoStatistics) {
        double threeMatchTotalMoney = LottoRank.THREE_MATCH.getPrizeMoney() * lottoStatistics.getThreeNumbersMatch();
        double fourMatchTotalMoney = LottoRank.FOUR_MATCH.getPrizeMoney() * lottoStatistics.getFourNumbersMatch();
        double fiveMatchTotalMoney = LottoRank.FIVE_MATCH.getPrizeMoney() * lottoStatistics.getFiveNumbersMatch();
        double fiveAndBonusMatchTotalMoney = LottoRank.FIVE_AND_BONUS_MATCH.getPrizeMoney() * lottoStatistics.getFiveNumbersAndBonusNumberMatch();
        double sixMatchTotalMoney = LottoRank.SIX_MATCH.getPrizeMoney() * lottoStatistics.getSixNumbersMatch();

        double allMoney = threeMatchTotalMoney + fourMatchTotalMoney + fiveMatchTotalMoney
                + fiveAndBonusMatchTotalMoney + sixMatchTotalMoney;

        return allMoney;
    }

    private double roundToTwoDecimal(double value) {
        return Math.round(value * SECOND_DECIMAL_NUMBER) / SECOND_DECIMAL_NUMBER;
    }
}
