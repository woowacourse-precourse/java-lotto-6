package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Statistic {
    private final Map<Rank, Integer> statistic;

    public Statistic(LottoTickets lottoTickets, WinningLotto winningLotto) {
        this.statistic = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values()).
                forEach(rank -> statistic.put(rank, 0));

        compareLottoTicket(lottoTickets, winningLotto);
    }

    private void compareLottoTicket(LottoTickets lottoTickets, WinningLotto winningLotto) {
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            Rank rank = winningLotto.compare(lotto);
            updateRankCount(rank);
        }
    }

    private void updateRankCount(Rank rank) {
        statistic.put(rank, statistic.get(rank) + 1);
    }

    public int getRankCount(Rank rank) {
        return statistic.get(rank);
    }

    public double getRate(int budget) {
        AtomicInteger sum = new AtomicInteger();
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.LOSE))
                .forEach(rank -> sum.addAndGet(rank.getWinningMoney() * statistic.get(rank)));

        double rate = (double) sum.get() / budget * 100.0;
        return rate;
    }
}
