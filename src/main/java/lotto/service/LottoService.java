package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

import java.util.List;

public class LottoService {


    public LottoResult calculateResult(List<Lotto> myLottos, WinningNumbers winningNumbers) {

        LottoResult lottoResult = new LottoResult();

        for (Lotto lotto : myLottos) {
            int matchCount = lotto.getMatchCount(winningNumbers);
            boolean isBonusMatch = lotto.isBonusMatch(winningNumbers);
            Rank rank = Rank.valueOf(matchCount, isBonusMatch);

            lottoResult.addRank(rank);
        }
        return lottoResult;
    }
}
