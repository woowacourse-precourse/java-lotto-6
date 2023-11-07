package lotto.domain.utils;

import lotto.domain.model.LottoTicket;
import lotto.domain.model.LottoWinningNumber;

public class LottoRankingService {
    private final LottoWinningNumber winningNumbers;

    public LottoRankingService(LottoWinningNumber winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Integer calculateRanking(LottoTicket ticket) {
        long matchCount = countMatchingNumbers(ticket);
        boolean matchBonus = isMatchBonus(ticket);
        return convertMatchingNumberToRanking(matchCount, matchBonus);
    }

    private long countMatchingNumbers(LottoTicket ticket) {
        return ticket.compareTo(winningNumbers);
    }

    private boolean isMatchBonus(LottoTicket ticket) {
        return ticket.getNumbers()
                .contains(winningNumbers.getBonusNumber());
    }

    private Integer convertMatchingNumberToRanking(long matchingNumber, boolean matchBonus) {
        CountToRankMappingTable table = new CountToRankMappingTable();
        return table.getRanking(matchingNumber, matchBonus);
    }
}
