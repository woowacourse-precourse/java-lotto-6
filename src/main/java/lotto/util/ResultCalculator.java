package lotto.util;

import lotto.model.*;

import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

    public List<Result> calculateWinningResults(UserLotto lottos, WinningLotto winningLotto) {
        List<Result> winningResults = new ArrayList<>();
        for (Lotto lotto : lottos.getUserLotto()) {
            Result winningResult = calculateWinningResult(lotto, winningLotto);
            winningResults.add(winningResult);
        }
        return winningResults;
    }

    private Result calculateWinningResult(Lotto userLotto, WinningLotto winningLotto) {
        int matchCount = countMatchNumbers(userLotto, winningLotto);
        boolean hasBonus = userLotto.contains(winningLotto.getBonusNumber());

        if (hasBonus) {
            matchCount++;
        }

        return Result.of(matchCount, hasBonus);
    }

    private int countMatchNumbers(Lotto userLotto, WinningLotto winningLotto) {
        return (int) userLotto.getNumbers().stream()
                .filter(winningLotto::contains)
                .count();
    }

    public long countMatchingResults(List<Result> winningResults, Rank rank) {
        return winningResults.stream()
                .filter(result -> result.getRank() == rank)
                .count();
    }

    public double calculateProfit(List<Result> winningResults, Amount purchaseAmount) {
        int totalPrize = winningResults.stream()
                .mapToInt(Result::getPrize)
                .sum();

        double profitRatio = (double) totalPrize / purchaseAmount.getAmount();
        return profitRatio * 100;
    }
}
