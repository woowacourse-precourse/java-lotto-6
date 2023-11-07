package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import lotto.enums.Rank;

public class Lottery {
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;
    private final LottoTicket lottoTicket;

    public Lottery(WinningNumber winningNumber, BonusNumber bonusNumber, LottoTicket lottoTicket) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.lottoTicket = lottoTicket;
    }

    public LottoResult createLottoResult() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        countRank(result);
        return new LottoResult(result, lottoTicket.getLottoCount());
    }

    private void countRank(Map<Rank, Integer> result) {
        lottoTicket.getLottoTicket().stream()
                .map(lotto -> Rank.findRankMatchesThat(winningNumber, bonusNumber, lotto))
                .forEach(rank -> increaseRankCount(result, rank));
    }

    private void increaseRankCount(Map<Rank, Integer> result, Rank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }
}
