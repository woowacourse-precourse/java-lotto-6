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