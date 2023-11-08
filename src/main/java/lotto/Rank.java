package lotto;

public enum Rank {
    FIRST(6, "2,000,000,000", "6개 일치"),
    SECOND(5, "30,000,000", "5개 일치, 보너스 볼 일치"),
    THIRD(5, "1,500,000", "5개 일치"),
    FOURTH(4, "50,000", "4개 일치"),
    FIFTH(3, "5,000", "3개 일치"),
    NONE(0, "0", "");

    private final int matchCount;
    private final String prize;
    private final String description;

    Rank(int matchCount, String prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public String getPrize() {
        return prize;
    }

    public String getDescription() {
        return description+" ("+prize+"원)";
    }

    // 상금을 int로 변환하는 메소드를 Rank 내에 포함
    public int getPrizeAsInt() {
        return Integer.parseInt(prize.replaceAll(",", ""));
    }
}
