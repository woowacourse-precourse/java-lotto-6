package lotto;

import java.text.DecimalFormat;

public enum Rank {
    FIRST(1, 2_000_000_000L, 6, false),
    SECOND(2, 30_000_000L, 5, true),
    THIRD(3, 1_500_000L, 5, false),
    FOURTH(4, 50_000L, 4, false),
    FIFTH(5, 5_000L, 3, false),
    OTHERS(0, 0L, 0, false); // 나머지 등수

    private final int number;
    private final long prizeAmount;
    private final int numberOfMatching;
    private final boolean isBonusNumberMatching;
    private final String description;

    private Rank(int rank, long prizeAmount, int numberOfMatching, boolean isBonusNumberMatching) {
        this.number = rank;
        this.prizeAmount = prizeAmount;
        this.numberOfMatching = numberOfMatching;

        String bonusMatchingDescription = "";
        this.isBonusNumberMatching = isBonusNumberMatching;
        if (isBonusNumberMatching) {
            bonusMatchingDescription = ", 보너스 볼 일치";
        }

        String commaSeparatedPrizeAmount = new DecimalFormat("#,###").format(prizeAmount);

        this.description = String.format("%d개 일치%s (%s원)", numberOfMatching, bonusMatchingDescription, commaSeparatedPrizeAmount);
    }

    public static Rank of(int number) {
        validate(number);
        return Rank.values()[number - 1];
    }

    private static void validate(int number) {
        if (number < 0 || number > 5) {
            throw new IllegalArgumentException("순위는 1등부터 4등이어야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public String getDescription() {
        return description;
    }
}
