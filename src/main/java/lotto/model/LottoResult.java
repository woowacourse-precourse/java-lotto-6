package lotto.model;

import static lotto.constants.LottoConstants.THOUSAND;

import java.util.EnumMap;
import java.util.EnumSet;

public class LottoResult {
    private final EnumMap<Rank, Integer> lottoResult;

    private LottoResult(EnumMap<Rank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public static LottoResult calculateLottoResult(WinningLotto winningLotto, LottoTickets lottoTickets) {
        EnumMap<Rank, Integer> rank = new EnumMap<>(Rank.class);
        EnumSet.allOf(Rank.class).forEach(grade -> rank.put(grade, 0));
        updateRank(rank, winningLotto, lottoTickets);
        return new LottoResult(rank);
    }

    private static void updateRank(EnumMap<Rank, Integer> rank, WinningLotto winningLotto, LottoTickets lottoTickets) {
        for (Lotto lottoTicket : lottoTickets.getLottoTickets()) {
            int matchCount = winningLotto.getMatchCount(lottoTicket);
            Rank currentRank = Rank.findRankByMatchCount(matchCount, winningLotto.hasBonusNumber(lottoTicket));
            rank.put(currentRank, rank.get(currentRank) + 1);
        }
    }

    public double getRate(Money money) {
        long sumReward = getLottoResult().entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
        return ((double)sumReward / THOUSAND) / money.getLottoCount() * 100;
    }

    public EnumMap<Rank, Integer> getLottoResult() {
        return lottoResult;
    }
}
