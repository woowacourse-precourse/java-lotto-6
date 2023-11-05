package lotto.domain;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

public enum WinningRank {
    FIFTH(3, "3개 일치 (%s원) - %d개", 5_000, 0),
    FOURTH(4, "4개 일치 (%s원) - %d개", 50_000, 0),
    THIRD(5, "5개 일치 (%s원) - %d개", 1_500_000, 0),
    SECOND(5, "5개 일치, 보너스 볼 일치 (%s원) - %d개", 30_000_000, 0),
    FIRST(6, "6개 일치 (%s원) - %d개", 2_000_000_000, 0);

    private final int matchCount;
    private final String message;
    private final int prizeMoney;
    private int winCount;

    WinningRank(int matchCount, String message, int prizeMoney, int winCount) {
        this.matchCount = matchCount;
        this.message = message;
        this.prizeMoney = prizeMoney;
        this.winCount = winCount;
    }

    public void addWinCount() {
        this.winCount++;
    }

    public boolean isMatch(long matchCount, boolean bonusMatch) {
        if (this == SECOND) {
            return matchCount == this.matchCount && bonusMatch;
        }

        return matchCount == this.matchCount;
    }

    public static String getWinningHistory() {
        return Arrays.stream(values())
                .map(WinningRank::getMessage)
                .collect(Collectors.joining("\n"));
    }

    public static double calculateTotalPrizeMoney() {
        return Arrays.stream(values())
                .mapToDouble(WinningRank::calculateIndividualPrizeMoney)
                .sum();
    }

    private String getMessage() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        String formattedPrizeMoney = numberFormat.format(prizeMoney);
        return String.format(message, formattedPrizeMoney, winCount);
    }

    private int calculateIndividualPrizeMoney() {
        return prizeMoney * winCount;
    }
}
