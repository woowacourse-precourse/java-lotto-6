package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Stream;

public class LottoGame {

    private final EnumMap<LottoRank, Long> rankFrequencies;

    public LottoGame(final WinningNumber winningNumber, final List<Lotto> lottoTickets) {
        this.rankFrequencies = calculateRankFrequencies(winningNumber, lottoTickets);
    }

    public WinningResult play() {
        final WinningResult winningResult = new WinningResult();

        for (final LottoRank rank : rankFrequencies.keySet()) {
            winningResult.addItem(WinningSummary.from(rank, rankFrequencies.get(rank)));
        }
        return winningResult;
    }

    private EnumMap<LottoRank, Long> calculateRankFrequencies(
            final WinningNumber winningNumber,
            final List<Lotto> lottoTickets
    ) {
        final EnumMap<LottoRank, Long> frequencies = new EnumMap<>(LottoRank.class);
        Stream.of(LottoRank.values()).forEach(rank -> frequencies.put(rank, 0L));

        for (final Lotto ticket : lottoTickets) {
            final LottoRank rank = winningNumber.compare(ticket);
            frequencies.put(rank, frequencies.get(rank) + 1L);
        }
        frequencies.remove(LottoRank.NONE);
        return frequencies;
    }
}
