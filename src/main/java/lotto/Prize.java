package lotto;

public enum Prize {
    NONE(0),
    SIX_MATCH(2000000000),
    FIVE_MATCH_BONUS(30000000),
    FIVE_MATCH(1500000),
    FOUR_MATCH(50000),
    THREE_MATCH(5000);

    private final int winningAmount;

    Prize(int winningAmount) {
        this.winningAmount = winningAmount;
    }

    public String getDescription() {
        switch (this) {
            case NONE:
                return "당첨 없음";
            case SIX_MATCH:
                return "6개 일치 (2,000,000,000원)";
            case FIVE_MATCH_BONUS:
                return "5개 일치, 보너스 볼 일치 (30,000,000원)";
            case FIVE_MATCH:
                return "5개 일치 (1,500,000원)";
            case FOUR_MATCH:
                return "4개 일치 (50,000원)";
            case THREE_MATCH:
                return "3개 일치 (5,000원)";
            default:
                throw new IllegalArgumentException("Invalid prize type: " + this);
        }
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public static Prize calculatePrize(int matchingCount, boolean hasBonusNumber) {
        if (matchingCount == 6) {
            return SIX_MATCH;
        } else if (matchingCount == 5 && hasBonusNumber) {
            return FIVE_MATCH_BONUS;
        } else if (matchingCount == 5) {
            return FIVE_MATCH;
        } else if (matchingCount == 4 ) {
            return FOUR_MATCH;
        } else if (matchingCount == 3) {
            return THREE_MATCH;
        } else {
            return NONE;
        }
    }
}
