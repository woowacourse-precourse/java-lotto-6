package lotto.domain;

public class ProfitRate {
    private final double rate;

    public ProfitRate(Money money, Prize prize) {
        this.rate = (getAllMoney(prize) * 0.1 / money.getTicketCount());
    }

    private long getAllMoney(Prize prize) {
        int result = 0;

        for (Ranking ranking : Ranking.values()) {
            result += prize.getPrizeCount(ranking) * ranking.getMoney();
        }

        return result;
    }

    public double getRate() {
        return rate;
    }
}
