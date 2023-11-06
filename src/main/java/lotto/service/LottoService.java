package lotto.service;

import java.util.List;
import lotto.constant.LottoConstant;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumber;

public class LottoService {
    public LottoResult getLottoResult(List<Lotto> lottos, WinningNumber winningNumber, BonusNumber bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            int matchCount = calculateMatch(lotto, winningNumber);
            boolean isBonus = isBonusMatch(lotto, bonusNumber);
            int rank = getRank(matchCount, isBonus);
            lottoResult.add(rank);
        }

        return lottoResult;
    }

    private int getRank(int matchCount, boolean isBonus) {
        if (matchCount == 6) {
            return 1;
        } else if (matchCount == 5 && isBonus) {
            return 2;
        } else if (matchCount == 5) {
            return 3;
        } else if (matchCount == 4) {
            return 4;
        } else if (matchCount == 3) {
            return 5;
        }
        return 0;
    }

    private boolean isBonusMatch(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.contains(bonusNumber.get())) {
            return true;
        }
        return false;
    }

    private int calculateMatch(Lotto lotto, WinningNumber winningNumber) {
        int matchCount = 0;
        for (int i = 0; i < LottoConstant.LOTTO_LENGTH; i++) {
            int number = winningNumber.get(i);
            if (lotto.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
