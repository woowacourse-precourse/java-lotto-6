package lotto;

import java.math.BigDecimal;

public enum Result {

    THREE_MATCH("3개 일치", "5,000원", BigDecimal.valueOf(5000), 3),
    FOUR_MATCH("4개 일치",  "50,000원", BigDecimal.valueOf(50000), 4),
    FIVE_MATCH("5개 일치",  "1,500,000원", BigDecimal.valueOf(1500000), 5),
    FIVE_MATCH_AND_PLUS("5개 일치, 보너스 볼 일치", "30,000,000원", BigDecimal.valueOf(30000000), 5),
    SIX_MATCH("6개 일치",  "2,000,000,000원", BigDecimal.valueOf(2000000000), 6);

    private final String description;

    private String prize;
    private final BigDecimal prizeMoney;

    private final Integer matchCount;

    Result(String description, String prize, BigDecimal prizeMoney, Integer matchCount) {
        this.description = description;
        this.prize = prize;
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
    }

    public String getDescription() {
        return description;
    }

    public String getPrize() {
        return prize;
    }

    public BigDecimal getPrizeMoney() {
        return prizeMoney;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public static Result getResult(Integer matchCount, boolean isBonusNumber) {
        if (matchCount == 5 && isBonusNumber == Boolean.TRUE) {
            return Result.FIVE_MATCH_AND_PLUS;
        }

        if (matchCount == 5 && isBonusNumber == Boolean.FALSE) {
            return Result.FIVE_MATCH;
        }

        for (Result result : Result.values()) {
            if (result.getMatchCount() == matchCount) {
                return result;
            }
        }

        return null;
    }
}
