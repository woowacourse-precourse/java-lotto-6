package lotto.domain;

public enum Prize {
    FAIL("", 0, 0, false),
    FIFTH("3개 일치 (5,000원) - ", 5000, 3, false),
    FOURTH("4개 일치 (50,000원) - ", 50000, 4, false),
    THIRD("5개 일치 (1,500,000원) - ", 1500000, 5, false),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000, 5, true),
    FIRST("6개 일치 (2,000,000,000원) - ", 2000000000, 6, false);

    private final String message;
    private final int reward;
    private final int sameNumberCount;
    private final boolean bonus;

    Prize(String message, int reward, int sameNumberCount, boolean bonus) {
        this.message = message;
        this.reward = reward;
        this.sameNumberCount = sameNumberCount;
        this.bonus = bonus;
    }

    public static Prize findBySameNumberCountAndBonus(int sameNumberCount, boolean bonus) {
        for (Prize prize : Prize.values()) {
            if (existBySameNumberCountAndBonus(prize, sameNumberCount, bonus)) {
                return prize;
            }
        }
        return FAIL;
    }

    private static boolean existBySameNumberCountAndBonus(Prize prize, int sameNumberCount, boolean bonus) {
        if (prize.sameNumberCount != sameNumberCount) {
            return false;
        }

        if (sameNumberCount == SECOND.sameNumberCount) {
            return prize.bonus == bonus;
        }
        return true;


    }

    public String getMessage() {
        return message;
    }

    public int getReward() {
        return reward;
    }
}
