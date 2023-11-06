package lotto.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lotto.util.enumerator.LottoRank;
import lotto.util.enumerator.WinningAmount;

public class ProfitService {
    public long calculateTotalProfitAmount(List<WinningAmount> winningAmount) {
        long result = 0L;
        for (WinningAmount amount : winningAmount) {
            result += amount.getAmount();
        }
        return result;
    }

    /* 이 메서드는 외부로 이동 필요 */
    public List<WinningAmount> copyWinningAmountFromLottoRanks(List<LottoRank> ranks) {
        List<WinningAmount> winningAmounts = new ArrayList<>();
        for (LottoRank rank : ranks) {
            winningAmounts.add(checkWinningAmount(rank));
        }
        return winningAmounts;
    }

    private WinningAmount checkWinningAmount(LottoRank rank) {
        if (isEqualRank(rank, LottoRank.FIRST)) {
            return WinningAmount.FIRST;
        }
        if (isEqualRank(rank, LottoRank.SECOND)) {
            return WinningAmount.SECOND;
        }
        if (isEqualRank(rank, LottoRank.THIRD)) {
            return WinningAmount.THIRD;
        }
        if (isEqualRank(rank, LottoRank.FOURTH)) {
            return WinningAmount.FOURTH;
        }
        if (isEqualRank(rank, LottoRank.FIFTH)) {
            return WinningAmount.FIFTH;
        }
        return WinningAmount.NONE;
    }

    public double calculateTotalProfitRate(double profitAmount, double purchaseAmount) {
        double profitRate = calculateRate(profitAmount, purchaseAmount);
        return calculateRoundedRate(profitRate);
    }

    private double calculateRate(double profitAmount, double purchaseAmount) {
        return profitAmount / purchaseAmount * 100.0;
    }

    private double calculateRoundedRate(double profitRate) {
        return Math.round(profitRate * 100) / 100.0;
    }

    private boolean isEqualRank(LottoRank first, LottoRank second) {
        return Objects.equals(first, second);
    }
}
