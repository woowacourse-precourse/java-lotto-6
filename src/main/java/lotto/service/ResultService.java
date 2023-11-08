package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinningNumber;

public class ResultService {
    private final LottoResult lottoResult;

    public ResultService() {
        this.lottoResult = new LottoResult();
    }


    public LottoResult calculateResults(LottoTicket lottoTicket,
                                        LottoWinningNumber lottoWinningNumber) {
        for (Lotto lotto : lottoTicket.getTickets()) {
            int matchCount = calculateMatchCount(lotto, lottoWinningNumber.getWinningNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(lottoWinningNumber.getBonusNumber());
            LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
            lottoResult.addWinningRank(rank);
        }
        return this.lottoResult;
    }

    private int calculateMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
