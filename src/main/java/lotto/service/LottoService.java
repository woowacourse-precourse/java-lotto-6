package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

import java.util.List;

import static lotto.domain.LottoConst.LOTTO_PRICE;

public class LottoService {

    public int getBuyCount(int input) {
        int buyCount = input / LOTTO_PRICE;
        System.out.println(buyCount + "개를 구매했습니다.");
        return buyCount;
    }

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
