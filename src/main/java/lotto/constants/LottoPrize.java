package lotto.constants;

public enum LottoPrize {

    FIRST(6, "6개 일치 (2,000,000,000원) - ", 2_000_000_000),
    SECOND(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000),
    THIRD(5, "5개 일치 (1,500,000원) - ", 1_500_000),
    FOURTH(4, "4개 일치 (50,000원) - ", 50_000),
    FIFTH(3, "3개 일치 (5,000원) - ", 5_000);

    private final int matchingNumber;
    private final String description;
    private final int price;

    LottoPrize(int matchingNumber, String description, int price) {
        this.matchingNumber = matchingNumber;
        this.description = description;
        this.price = price;
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public LottoPrize rank(int matchingCount, boolean hasBonus) {
        if (matchingCount == FIRST.matchingNumber) {
            return FIRST;
        }
        if (matchingCount == SECOND.matchingNumber) {
            return rankBonus(hasBonus);
        }
        if (matchingCount == FOURTH.matchingNumber) {
            return FOURTH;
        }
        if (matchingCount == FIFTH.matchingNumber) {
            return FIFTH;
        }
        return null;
    }

    private LottoPrize rankBonus(boolean hasBonus) {
        if (hasBonus) {
            return SECOND;
        }
        return THIRD;
    }
}
