package domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class LottoResult {
    private final Map<Rank, Integer> lottoResult;

    public LottoResult() {
        lottoResult = new EnumMap<Rank, Integer>(Rank.class);
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, 0);
        }
    }

    public void calcLottoResult(LottoTicket lottoTicket, WinningLotto winningLotto) {
        for (Lotto lotto : lottoTicket.getLottoTicket()) {
            boolean hasBonusNumber = lotto.hasNumber(winningLotto.getBonusNumber());
            int matchedNumbers = lotto.getMatchedNumbers(winningLotto);

            Rank rank = Rank.getRank(matchedNumbers, hasBonusNumber);

            if (!Objects.isNull(rank)) {
                updateLottoResult(rank);
            }
        }
    }

    public void updateLottoResult(Rank rank) {
        lottoResult.put(rank, lottoResult.get(rank) + 1);
    }

    public int getEachRankResult(Rank rank) {
        return lottoResult.get(rank);
    }


}
