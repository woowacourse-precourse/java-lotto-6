package lotto;

public enum Rank {
    FIRST(1, 2_000_000_000L, "6개 일치 (2,000,000,000원)"),
    SECOND(2, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(3, 1_500_000L, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000L, "4개 일치 (50,000원)"),
    FIFTH(5, 5_000L, "3개 일치 (5,000원)"),
    OTHERS(0, 0L, ""); // 나머지 등수

    private final int number;
    private final long prizeAmount;
    private final String description;

    private Rank(int rank, long prizeAmount, String description) {
        this.number = rank;
        this.prizeAmount = prizeAmount;
        this.description = description;
    }

    public static Rank of(int number) {
        validate(number);
        return Rank.values()[number - 1];
    }

    private static void validate(int number) {
        if (number < 0 || number > 5) {
            throw new IllegalArgumentException("[ERROR] 순위는 1등부터 4등이어야 합니다.");
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
