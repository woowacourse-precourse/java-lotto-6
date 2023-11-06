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
        for (Lotto lotto : lottoTicket.getLottoTicket()) {
            Rank rank = Rank.findRank(winningNumber, bonusNumber, lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return new LottoResult(result, lottoTicket.getLottoCount());
    }
}
