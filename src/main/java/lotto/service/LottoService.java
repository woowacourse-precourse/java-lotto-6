package lotto.service;

import java.util.List;
import lotto.constant.LottoConstant;
import lotto.constant.Prize;
import lotto.constant.Rank;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public class LottoService {
    public LottoResult getLottoResult(final List<Lotto> lottos,
                                    final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            int matchCount = calculateMatch(lotto, winningNumbers);
            boolean isBonus = isBonusMatch(lotto, bonusNumber);
            int rank = getRank(matchCount, isBonus);
            lottoResult.add(rank);
        }
        return lottoResult;
    }

    public float getRevenue(final LottoResult lottoResult) {
        float revenue = 0;
        for (int rank = Rank.FIRST.getRank(); rank <= Rank.FIFTH.getRank(); rank++) {
            if (lottoResult.contains(rank)) {
                int rankCount = lottoResult.get(rank);
                revenue += calculateRevenue(rank) * rankCount;
            }
        }
        return revenue;
    }

    public float getEarningRate(final PurchaseAmount purchaseAmount, float revenue) {
        if (revenue == 0) {
            return 0;
        }
        return (revenue * 100) / purchaseAmount.getAmount();
    }

    public int getLottoCount(final PurchaseAmount purchaseAmount) {
        return purchaseAmount.getAmount() / LottoConstant.LOTTO_PRICE;
    }

    private int calculateMatch(final Lotto lotto, final WinningNumbers winningNumbers) {
        List<Integer> lottoWinningNumbers = winningNumbers.getNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchCount = 0;
        for (int i = 0; i < LottoConstant.LOTTO_LENGTH; i++) {
            int number = lottoWinningNumbers.get(i);
            if (lottoNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean isBonusMatch(final Lotto lotto, final BonusNumber bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        if (lottoNumbers.contains(bonusNumber.get())) {
            return true;
        }
        return false;
    }

    private int getRank(int matchCount, boolean isBonus) {
        if (matchCount == 6) {
            return Rank.FIRST.getRank();
        } else if (matchCount == 5 && isBonus) {
            return Rank.SECOND.getRank();
        } else if (matchCount == 5) {
            return Rank.THIRD.getRank();
        } else if (matchCount == 4) {
            return Rank.FOURTH.getRank();
        } else if (matchCount == 3) {
            return Rank.FIFTH.getRank();
        }
        return Rank.NO.getRank();
    }

    private int calculateRevenue(int rank) {
        int revenue = 0;
        if (rank == Rank.FIRST.getRank()) {
            revenue += Prize.FIRST.getPrize();
        } else if (rank == Rank.SECOND.getRank()) {
            revenue += Prize.SECOND.getPrize();
        } else if (rank == Rank.THIRD.getRank()) {
            revenue += Prize.THIRD.getPrize();
        } else if (rank == Rank.FOURTH.getRank()) {
            revenue += Prize.FOURTH.getPrize();
        } else if (rank == Rank.FIFTH.getRank()) {
            revenue += Prize.FIFTH.getPrize();
        }
        return revenue;
    }
}
