package lotto.model;

public enum LottoPrize {
    //TODO: THREE_MATCH 혹은 FIFTH, 현상태로 이름을 지을것인지 등수로 이름을 지을것인지
    THREE_MATCH(3, false, 5_000, "3개 일치 (5,000원) - %s개"),
    FOUR_MATCH(4, false, 50_000, "4개 일치 (50,000원) - %s개"),
    FIVE_MATCH(5, false, 1_500_000, "5개 일치 (1,500,000원) - %s개"),
    FIVE_WITH_BONUS(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %s개"),
    SIX_MATCH(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - %s개");

    private final Integer match;
    private final Boolean isSameBonus;
    private final Integer prize;
    private final String message;

    LottoPrize(Integer match, Boolean isSameBonus, Integer prize, String message) {
        this.match = match;
        this.isSameBonus = isSameBonus;
        this.prize = prize;
        this.message = message;
    }

    public static LottoPrize from(Integer match, Boolean isSameBonus) {
        if (FIVE_WITH_BONUS.match.equals(match) && FIVE_WITH_BONUS.isSameBonus.equals(isSameBonus)) {
            return FIVE_WITH_BONUS;
        }
        for (LottoPrize prize : LottoPrize.values()) {
            if (prize.match.equals(match)) {
                return prize;
            }
        }
        return null;
    }

    public Integer getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
