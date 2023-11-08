package lotto.constants;

public enum Prize {
    FIRST(6, "6개 일치 (2,000,000,000원) - ", 2_000_000_000),
    SECOND(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000),
    THIRD(5, "5개 일치 (1,500,000원) - ", 1_500_000),
    FOURTH(4, "4개 일치 (50,000원) - ", 50_000),
    FIFTH(3, "3개 일치 (5,000원) - ", 5_000);

    private final Integer matchingNumber;
    private final String description;
    private final Integer prizeAmount;

    Prize(Integer matchingNumber, String description, Integer prizeAmount) {
        this.matchingNumber = matchingNumber;
        this.description = description;
        this.prizeAmount = prizeAmount;
    }

    public static Prize rank(int matchingCount, boolean hasBonus) {
        if (matchingCount == FIRST.matchingNumber) {
            return FIRST;
        }
        if (matchingCount == SECOND.matchingNumber) {
            if (hasBonus) {
                return Prize.SECOND;
            }
            return Prize.THIRD;
        }
        if (matchingCount == FOURTH.matchingNumber) {
            return Prize.FOURTH;
        }
        if (matchingCount == FIFTH.matchingNumber) {
            return Prize.FIFTH;
        }
        return null;
    }

    public Integer getMatchingNumber() {
        return matchingNumber;
    }

    public String getDescription() {
        return description;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
