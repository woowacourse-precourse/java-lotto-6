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

    public int getRevenue(LottoResult lottoResult) {
        int revenue = 0;
        for (int rank = 1; rank <= LottoConstant.LAST_RANK; rank++) {
            if (lottoResult.contains(rank)) {
                int rankCount = lottoResult.get(rank);
                revenue += calculateRevenue(rank) * rankCount;
            }
        }
        return revenue;
    }

    private int calculateRevenue(int rank) {
        int revenue = 0;
        if (rank == 1) {
            revenue += LottoConstant.FIRST_PRIZE;
        } else if (rank == 2) {
            revenue += LottoConstant.SECOND_PRIZE;
        } else if (rank == 3) {
            revenue += LottoConstant.THIRD_PRIZE;
        } else if (rank == 4) {
            revenue += LottoConstant.FOURTH_PRIZE;
        } else if (rank == 5) {
            revenue += LottoConstant.FIFTH_PRIZE;
        }
        return revenue;
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
