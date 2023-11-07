package domain;

public class IncomeRate {
    private final double rate;

    public IncomeRate(Money money, LottoResult lottoResult) {
        this.rate = (calcIncome(lottoResult) / (double) money.getMoney()) * 100;
    }


    public long calcIncome(LottoResult lottoResult) {
        long result = 0;

        for (Rank rank : Rank.values()) {
            result += (long) lottoResult.getEachRankResult(rank) * rank.getPrize();
        }

        return result;
    }


    public double getRate() {
        return rate;
    }
}
