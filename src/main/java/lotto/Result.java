package lotto;

public enum Result {

    THREE_MATCH("3개 일치", "5,000원"),
    FOUR_MATCH("4개 일치", "50,000원"),
    FIVE_MATCH("5개 일치", "1,500,000원"),
    FIVE_MATCH_AND_PLUS("5개 일치, 보너스 볼 일치", "30,000,000원"),
    SIX_MATCH("6개 일치", "2,000,000,000원");

    private final String description;
    private final String prizeMoney;

    Result(String description, String prizeMoney) {
        this.description = description;
        this.prizeMoney = prizeMoney;
    }

    public String getDescription() {
        return description;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }
}
