package domain;

public class IncomeRate {
    private final double rate;

    public IncomeRate(Money money, LottoResult lottoResult) {
        this.rate =(calcIncome(lottoResult) * 0.1) / money.buyLottoTicket();
    }

    public long calcIncome(LottoResult lottoResult) {
        long result = 0;

        for (Rank rank : Rank.values()) {
            result += lottoResult.getEachRankResult(rank) * rank.getPrize();
        }

        return result;
    }

    public double getRate() {
        return rate;
    }
}
