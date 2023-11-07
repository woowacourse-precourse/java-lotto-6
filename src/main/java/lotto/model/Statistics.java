package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private Statistics() {}

    private static Map<Rank, Integer> initWinningStatus() {
        Map<Rank, Integer> winningDetails = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            winningDetails.put(rank, 0);
        }
        return winningDetails;
    }

    public static Map<Rank, Integer> calculateRank(WinningLotto winningLotto, List<Lotto> lottoTicket) {
        Map<Rank, Integer> winningDetails = initWinningStatus();
        for (Lotto lotto : lottoTicket) {
            winningDetails.merge(winningLotto.compare(lotto), 1, Integer::sum);
        }
        return winningDetails;
    }

    public static String calculateProfitRate(Map<Rank, Integer> winningDetails, int money) {
        double profit = 0.0;
        for (Rank rank : winningDetails.keySet()) {
            profit += rank.getReward() * winningDetails.get(rank);
        }
        return String.format("%,.1f", profit * 100 / money);
    }
}
