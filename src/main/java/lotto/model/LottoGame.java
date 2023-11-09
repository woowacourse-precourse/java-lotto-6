package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class LottoGame {

    private final WinningNumber winningNumber;

    private final List<Lotto> lottoTickets;

    public LottoGame(final WinningNumber winningNumber, final List<Lotto> lottoTickets) {
        this.winningNumber = winningNumber;
        this.lottoTickets = lottoTickets;
    }

    public WinningResult play() {
        final Map<LottoRank, Long> frequencies = calculateRankFrequencies();
        final WinningResult winningResult = new WinningResult();

        for (final LottoRank rank : frequencies.keySet()) {
            winningResult.addItem(WinningSummary.from(rank, frequencies.get(rank)));
        }
        return winningResult;
    }

    private Map<LottoRank, Long> calculateRankFrequencies() {
        final Map<LottoRank, Long> frequencies = new EnumMap<>(LottoRank.class);
        Stream.of(LottoRank.values()).forEach(rank -> frequencies.put(rank, 0L));

        for (final Lotto ticket : lottoTickets) {
            final LottoRank rank = winningNumber.compare(ticket);
            frequencies.put(rank, frequencies.get(rank) + 1L);
        }
        frequencies.remove(LottoRank.NONE);
        return frequencies;
    }
}
