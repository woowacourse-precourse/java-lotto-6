package lotto.utils;

import lotto.dto.WinningStatus;

import java.util.List;

public class Calculator {

    private Calculator() {
    }

    public static double calculateReturnRate(List<WinningStatus> winningStatuses, int purchaseAmount) {
        int totalIncome = calculateTotalIncome(winningStatuses);
        return (double) totalIncome / purchaseAmount * 100;
    }

    private static int calculateTotalIncome(List<WinningStatus> winningStatuses) {
        return winningStatuses.stream()
                .mapToInt(Calculator::calculateIncome)
                .sum();
    }

    private static int calculateIncome(WinningStatus winningStatus) {
        return winningStatus.winningType().getReward() * winningStatus.count();
    }
}
