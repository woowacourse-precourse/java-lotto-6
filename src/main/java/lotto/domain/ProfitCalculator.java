package lotto.domain;

import java.util.List;
import lotto.domain.repository.LottoResultRepository;
import lotto.domain.repository.PurchaseAmountRepository;
import lotto.util.enumerator.LottoRank;

public class ProfitCalculator {
    private static final double PERCENTAGE_DOUBLE = 100.0;

    public double calculateProfit() {
        List<LottoRank> ranks = LottoResultRepository.findLottoRankResults();

        long profitAmount = calculateTotalProfitAmount(ranks);
        int purchaseAmount = PurchaseAmountRepository.findAmount();

        return calculateTotalProfitRate(profitAmount, purchaseAmount);
    }

    private long calculateTotalProfitAmount(List<LottoRank> ranks) {
        return ranks.stream()
                .mapToLong(LottoRank::getAmount)
                .sum();
    }

    private double calculateTotalProfitRate(double profitAmount, double purchaseAmount) {
        return profitAmount / purchaseAmount * PERCENTAGE_DOUBLE;
    }
}
