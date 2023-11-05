package lotto.model;

public class TotalProfitCalculator {
    private final double totalProfit;
    private final int payment;

    public TotalProfitCalculator(LottoStatistics lottoStatistics, int payment) {
        this.totalProfit = calculateTotalProfit(lottoStatistics);
        this.payment = payment;
    }

    private double calculateTotalProfit(LottoStatistics lottoStatistics) {
        double allProfitMoney = calculateAllMoney(lottoStatistics);

        double decimal =  allProfitMoney / (double) payment;
    }

    private double calculateAllMoney(LottoStatistics lottoStatistics) {
        double threeMatchTotalMoney = 5000 * lottoStatistics.getThreeNumbersMatch();
        double fourMatchTotalMoney = 50000 * lottoStatistics.getFourNumbersMatch();
        double fiveMatchTotalMoney = 15000 * lottoStatistics.getFiveNumbersMatch();
        double fiveAndBonusMatchTotalMoney = 30000000 * lottoStatistics.getFiveNumbersAndBonusNumberMatch();
        double sixMatchTotalMoney = 2000000000 * lottoStatistics.getSixNumbersMatch();

        double allMoney = threeMatchTotalMoney + fourMatchTotalMoney + fiveMatchTotalMoney
                + fiveAndBonusMatchTotalMoney + sixMatchTotalMoney;

        return allMoney;
    }
}
