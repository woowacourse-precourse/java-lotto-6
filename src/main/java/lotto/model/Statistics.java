package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private static final int PERCENT_RATE = 100;
    private static final int ONE_COUNT = 1;

    private static final String CURRENCY_UNIT = "%,.1f";

    private Statistics() {
    }

    private static Map<Rank, Integer> initWinningDetails() {
        Map<Rank, Integer> winningDetails = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            winningDetails.put(rank, 0);
        }
        return winningDetails;
    }

    public static Map<Rank, Integer> calculateRank(WinningLotto winningLotto, List<Lotto> lottoTicket) {
        Map<Rank, Integer> winningDetails = initWinningDetails();
        for (Lotto lotto : lottoTicket) {
            winningDetails.merge(winningLotto.compare(lotto), ONE_COUNT, Integer::sum);
        }
        return winningDetails;
    }

    public static String calculateProfitRate(Map<Rank, Integer> winningDetails, int invest) {
        double profit = 0.0;
        for (Rank rank : winningDetails.keySet()) {
            profit += rank.getReward() * winningDetails.get(rank);
        }
        return String.format(CURRENCY_UNIT, profit * PERCENT_RATE / invest);
    }
}
