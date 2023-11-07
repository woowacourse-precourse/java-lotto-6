package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class WinningStatistics {
    private static final int WINNING_STATISTICS = 3;
    private static final int BONUS_CHECK_NUMBER = 5;
    private static final int BONUS_VALUE = 7;
    private List<Integer> winningStatistics = new ArrayList<>();

    public void makeWinningStatistics(LottoTickets lottoTickets, LuckyNumbers luckyNumbers) {
        int count = lottoTickets.getTicketCount();

        for (int i = 0; i < count; i++) {
            matchScore(lottoTickets.getTickets().get(i), luckyNumbers);
        }
    }

    private void matchScore(Lotto lotto, LuckyNumbers luckyNumbers) {
        int matchCount = matchCount(lotto, luckyNumbers);
        add(bonusCheck(matchCount, matchBonus(lotto, luckyNumbers)));
    }

    private int matchCount(Lotto lotto, LuckyNumbers luckyNumbers) {
        return lotto.matchCount(luckyNumbers);
    }

    private int bonusCheck(int count, boolean matchBonus) {
        if (count == BONUS_CHECK_NUMBER && matchBonus) {
            return BONUS_VALUE;
        }
        return count;
    }

    private boolean matchBonus(Lotto lotto, LuckyNumbers luckyNumbers) {
        if (lotto.getNumbers().contains(luckyNumbers.getBonusNumber())) {
            return true;
        }
        return false;
    }

    private void add(int count) {
        if (count >= WINNING_STATISTICS) {
            winningStatistics.add(count);
        }
    }

    public List<Integer> getWinningStatistics() {
        return winningStatistics;
    }
}
