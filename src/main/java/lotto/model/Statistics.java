package lotto.model;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;

public class Statistics {

    private final EnumMap<LottoRank, Long> rankMatchingCount;

    public Statistics(final WinningNumber winningNumber, final List<Lotto> lottoTickets) {
        rankMatchingCount = mapRankMatchingCount(winningNumber, lottoTickets);
    }

    private EnumMap<LottoRank, Long> mapRankMatchingCount(
            final WinningNumber winningNumber,
            final List<Lotto> lottoTickets
    ) {
        final EnumMap<LottoRank, Long> rankMatchingCount = new EnumMap<>(LottoRank.class);
        EnumSet.allOf(LottoRank.class).forEach(rank -> rankMatchingCount.put(rank, 0L));

        for (final Lotto ticket : lottoTickets) {
            final LottoRank rank = winningNumber.compare(ticket);
            rankMatchingCount.put(rank, rankMatchingCount.get(rank) + 1L);
        }
        return rankMatchingCount;
    }

    public List<WinningSummary> getResults() {
        return rankMatchingCount.keySet()
                .stream()
                .filter(rank -> !rank.isNone())
                .map(rank -> new WinningSummary(rank, rankMatchingCount.get(rank)))
                .toList();
    }
}
