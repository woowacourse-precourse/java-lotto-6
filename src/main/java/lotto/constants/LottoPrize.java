package lotto.constants;

public enum LottoPrize {

    FIFTH(3, "3개 일치 (5,000원) - %d개\n", 5_000),
    FOURTH(4, "4개 일치 (50,000원) - %d개\n", 50_000),
    THIRD(5, "5개 일치 (1,500,000원) - %d개\n", 1_500_000),
    SECOND(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", 30_000_000),
    FIRST(6, "6개 일치 (2,000,000,000원) - %d개\n", 2_000_000_000);
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

    public static LottoPrize rank(int matchingCount, boolean hasBonus) {
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

    private static LottoPrize rankBonus(boolean hasBonus) {
        if (hasBonus) {
            return SECOND;
        }
        return THIRD;
    }
}
