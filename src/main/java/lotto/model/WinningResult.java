package lotto.model;

import java.util.EnumMap;
import java.util.Map;
import lotto.common.Ranking;

public class WinningResult {

    private final WinningNumbers winningNumbers;
    private final LottoTickets lottoTickets;
    private final Lotto lotto;
    private static Map<Ranking, Integer> result = new EnumMap<>(Ranking.class);

    private WinningResult(WinningNumbers winningNumbers, LottoTickets lottoTickets, Lotto lotto) {
        this.winningNumbers = winningNumbers;
        this.lottoTickets = lottoTickets;
        this.lotto = lotto;
    }

    public static double getProfit(Map<Ranking, Integer> result, int amount) {
        double totalPrize = calculateTotalPrize(result);
        return totalPrize / (double) amount;
    }

    private static double calculateTotalPrize(Map<Ranking, Integer> result) {
        double totalPrize = 0.0;

        for (Ranking rank : Ranking.values()) {
            Integer counts = result.get(rank);
            int prize = Integer.parseInt(rank.getPrize());

            if (counts != null) {
                totalPrize += (double) counts * prize;
            }
        }
        return totalPrize;
    }

    private static Ranking getRankingForRank(int rank) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.getRank() == rank) {
                return ranking;
            }
        }
        return Ranking.NONE;
    }

    private static int determineWinningRank(Lotto lotto, LottoTicket lottoTicket, WinningNumbers winningNumbers) {
        int count = getMatchingCount(lotto, lottoTicket);
        if (isSecondRank(lottoTicket, winningNumbers.getBonusNumber(), count)) {
            return Ranking.SECOND.getRank();
        }
        return rankMatchingNumbers(count);

    }

    private static boolean isSecondRank(LottoTicket lottoTicket, Number bonusNumber, int count) {
        return lottoTicket.hasBonusNumber(bonusNumber) && count == 5;
    }

    private static int rankMatchingNumbers(int count) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.getMatchCount() == count) {
                return ranking.getRank();
            }
        }
        return 0;
    }

    private static int getMatchingCount(Lotto lotto, LottoTicket lottoTicket) {
        return lotto.countMatchingNumbers(lottoTicket);
    }

}