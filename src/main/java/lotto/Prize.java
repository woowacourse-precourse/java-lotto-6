package lotto;

import java.util.ArrayList;
import java.util.List;

public enum Prize {
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)");

    private static final String PRINT_WINNING_STATISTICS = "당첨 통계\n---";
    private static final String EARNING_RATE = "총 수익률은 %s%%입니다.";
    private final int count;
    private final int amount;

    private final String information;


    Prize(int count, int amount, String information) {
        this.count = count;
        this.amount = amount;
        this.information = information;
    }

    public static void startPrizeStatistics(int purchase) {
        List<Long> matchWinningNumber = WinningNumber.getMatchWinningNumber();
        List<Long> matchBonusNumber = WinningNumber.getMatchBonusNumber();

        List<String> prizeHistory = countPrizeHistory(matchWinningNumber, matchBonusNumber);
        printWinningStatistics(prizeHistory);
        String earningRate = earningRateCalculator(matchWinningNumber, matchBonusNumber, purchase);
        System.out.println(String.format(EARNING_RATE, earningRate));
    }

    public static Prize matchPrize(long matchWinningNumber, long matchBonusNumber) {
        if (matchWinningNumber == Prize.SECOND.count) {
            return bonusNumber(matchBonusNumber);
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
            return Prize.SECOND;
        }
        return Prize.THIRD;
    }

    public static String earningRateCalculator(List<Long> matchWinningNumber, List<Long> matchBonusNumber,
                                               int purchase) {
        double totalAmount = 0;
        for (int i = 0; i < matchWinningNumber.size(); i++) {
            Prize prize = Prize.matchPrize(matchWinningNumber.get(i), matchBonusNumber.get(i));
            if (prize != null) {
                totalAmount += prize.amount;
            }
        }
        String earningRate = String.format("%.1f", totalAmount * 100 / purchase);
        return earningRate;
    }

    public static List<String> countPrizeHistory(List<Long> matchWinningNumber, List<Long> matchBonusNumber) {
        List<String> prizeHistory = new ArrayList<>();
        for (int i = 0; i < matchWinningNumber.size(); i++) {
            Prize prize = Prize.matchPrize(matchWinningNumber.get(i), matchBonusNumber.get(i));
            if (prize != null) {
                prizeHistory.add(prize.name());
            }
        }
        return prizeHistory;
    }

    public static void printWinningStatistics(List<String> prizeHistory) {
        System.out.println(PRINT_WINNING_STATISTICS);
        for (Prize prize : Prize.values()) {
            long count = prizeHistory.stream().filter(p -> p.equals(prize.name())).count();
            System.out.println(prize.information + " - " + count + "개");
        }
    }

}

