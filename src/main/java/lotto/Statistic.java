package lotto;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import view.OutputView;

public class Statistic {
    private static final int TICKET_PRICE = 1000;
    private List<Lotto> lottos;
    private WinningLotto winner;
    private Map<Rank, Integer> result;
    private int ticketCount;

    public Statistic(List<Lotto> lottos, WinningLotto winner, int ticketCount) {
        this.lottos = lottos;
        this.winner = winner;
        this.ticketCount = ticketCount;
        result = new LinkedHashMap<>();

    }

    public void lottoResult() {
        initialize();
        for (Lotto lotto: lottos) {
            Rank rank = winner.getRank(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        showResult();
        showEarningRate();
    }

    private void showResult() {
        for (Rank rank : result.keySet()) {
            if (rank != Rank.LOSE) {
                rank.printMessage(rank, result.get(rank));
            }
        }
    }

    private void showEarningRate() {
        int totalPrize = 0;
        for (Rank rank : result.keySet()) {
            totalPrize += rank.getPrize() * result.get(rank);
        }

        double rate = (double) totalPrize / (ticketCount * TICKET_PRICE) * 100;
        OutputView.printEarningRate(rate);
    }

    private void initialize() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }
}
