package lotto.rank.domain;

public class RevenueCalculator {
    public static double calculateRevenueRate(RankCount rankCount, int purchaseAmount) {
        if (isSmallerThanZero(purchaseAmount)) {
            throw new IllegalArgumentException("구입 금액이 0보다 커야 합니다.");
        }

        double totalRevenue = rankCount.getUnmodifiableRankCount().entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();

        return (totalRevenue / purchaseAmount) * 100;
    }

    private static boolean isSmallerThanZero(int purchaseAmount) {
        return purchaseAmount <= 0;
    }
}
