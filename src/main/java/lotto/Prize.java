package lotto;

import java.util.ArrayList;
import java.util.List;

public enum Prize {
    THREE(3, 5000, "3개 일치 (5,000원)"),
    FOUR(4, 50000, "4개 일치 (50,000원)"),
    FIVE(5, 1500000, "5개 일치 (1,500,000원)"),
    BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX(6, 2000000000, "6개 일치 (2,000,000,000원)");
    private final int count;
    private final int amount;

    private final String information;

    private static List<String> prizeHistory = new ArrayList<>();

    Prize(int count, int amount, String information) {
        this.count = count;
        this.amount = amount;
        this.information = information;
    }

    public static void startPrizeStatistics(List<Long> matchWinningNumber, List<Long> matchBonusNumber, int purchase) {
        countPrizeHistory(matchWinningNumber, matchBonusNumber);
        printWinningStatistics();
        earningRateCalculator(matchWinningNumber, matchBonusNumber, purchase);
    }

    public static Prize matchPrize(long matchWinningNumber, long matchBonusNumber) {
        if (matchWinningNumber == Prize.BONUS.count) {
            bonusNumber(matchBonusNumber);
        }
        for (Prize prize : Prize.values()) {
            if (prize.count == matchWinningNumber) {
                return prize;
            }
        }
        return null;
    }

    public static Prize bonusNumber(long matchBonusNumber) {
        if (matchBonusNumber > 0) {
            return Prize.BONUS;
        }
        return Prize.FIVE;
    }

    public static void earningRateCalculator(List<Long> matchWinningNumber, List<Long> matchBonusNumber, int purchase) {
        double totalAmount = 0;
        for (int i = 0; i < matchWinningNumber.size(); i++) {
            Prize prize = Prize.matchPrize(matchWinningNumber.get(i), matchBonusNumber.get(i));
            if (prize != null) {
                totalAmount += prize.amount;
            }
        }
        String earningRate = String.format("%.1f", totalAmount * 100 / purchase);
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }

    public static void countPrizeHistory(List<Long> matchWinningNumber, List<Long> matchBonusNumber) {
        for (int i = 0; i < matchWinningNumber.size(); i++) {
            Prize prize = Prize.matchPrize(matchWinningNumber.get(i), matchBonusNumber.get(i));
            if (prize != null) {
                prizeHistory.add(prize.name());
            }
        }
    }

    public static void printWinningStatistics() {
        for (Prize prize : Prize.values()) {
            long count = prizeHistory.stream().filter(p -> p.equals(prize.name())).count();
            System.out.println(prize.information + " - " + count + "개");
        }
    }

}

