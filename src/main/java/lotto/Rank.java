package lotto;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Rank {

    FIFTH(3, 5000L, "5,000"),
    FOURTH(4, 50000L, "50,000"),
    THIRD(5, 1500000L, "1,500,000"),
    SECOND(5, 30000000L, "30,000,000"),
    FIRST(6, 2000000000L, "2,000,000,000");

    private final int count;
    private final long prizeMoney;
    private final String printablePrizeMoney;

    private Rank(int count, long prizeMoney, String printablePrizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
        this.printablePrizeMoney = printablePrizeMoney;
    }

    public String getMessage(int count) {
        if (this.name().equals("SECOND")) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", this.getCount(), this.getPrintablePrizeMoney(), count);
        }
        return String.format("%d개 일치 (%s원) - %d개", this.getCount(), this.getPrintablePrizeMoney(), count);
    }

    public static Rank of(int correctCount, boolean correctBonusNumber) {
        if (determinSecond(correctCount, correctBonusNumber)) {
            return SECOND;
        }
        Rank determindRank = Arrays.stream(values()).filter(rank -> rank.getCount() == correctCount)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("해당하는 Rank 없습니다."));

        return determindRank;
    }

    public static boolean determinSecond(int correctCount, boolean correctBonusNumber) {
        return correctCount == SECOND.getCount() && correctBonusNumber;
    }

    public int getCount() {
        return count;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrintablePrizeMoney() {
        return printablePrizeMoney;
    }
}
