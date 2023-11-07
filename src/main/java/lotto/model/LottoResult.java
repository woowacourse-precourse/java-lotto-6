package lotto.model;

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
        for (Lotto lottoTicket : lottoTickets.getLottoTickets()) {
            int matchCount = winningLotto.getMatchCount(lottoTicket);
            Rank currentRank = Rank.findRankByMatchCount(matchCount, winningLotto.hasBonusNumber(lottoTicket));
            rank.put(currentRank, rank.get(currentRank) + 1);
        }
        return new LottoResult(rank);
    }

    public double getRate(Money money) {
        long sumPrize = 0;
        for (Rank rank : getLottoResult().keySet()) {
            sumPrize += rank.getReward() * lottoResult.get(rank);
        }
        return ((double)sumPrize / 1000) / money.getTicket() * 100;
    }

    public EnumMap<Rank, Integer> getLottoResult() {
        return lottoResult;
    }
}
