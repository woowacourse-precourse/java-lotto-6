package lotto;

public class Calculate {
    private final double rate;
    public Calculate(Ticket ticket, ShowRanking showRanking) {
        this.rate = (getMoney(showRanking) * 0.1 / ticket.countTicket());
    }

    private long getMoney(ShowRanking showRanking) {
        int result = 0;

        for (Ranking ranking : Ranking.values()) {
            result += showRanking.getRankCount(ranking) * ranking.getMoney();
        }

        return result;
    }

    public double getRate() {
        return rate;
    }
}
