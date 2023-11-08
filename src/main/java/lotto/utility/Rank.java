package lotto.utility;

import static lotto.utility.Constants.CHECK_BONUS_CONDITION;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;

public enum Rank {
    FIRST(6, 2000000000, false, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30000000, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1500000, false, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50000, false, "4개 일치 (50,000원) - "),
    FIFTH(3, 5000, false, "3개 일치 (5,000원) - "),
    NONE(0, 0, false, "꽝");

    private final Integer matchedCount;
    private final Integer reward;
    private final boolean containBonus;
    private final String message;

    Rank(final Integer matchedCount, final Integer reward, boolean containBonus, String message) {
        this.matchedCount = matchedCount;
        this.reward = reward;
        this.containBonus = containBonus;
        this.message = message;
    }

    public Integer getMatchedCount() {
        return matchedCount;
    }

    public Integer getReward() {
        return reward;
    }

    public String getMessage() {
        return message;
    }

    public static Rank getRank(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
        Integer matchedCount = getMatchedCount(lotto, winningNumbers);
        boolean containBonus = false;
        if (matchedCount == CHECK_BONUS_CONDITION) {
            containBonus = lotto.hasNumber(bonusNumber);
        }
        return calculateRank(matchedCount, containBonus);
    }

    private static Integer getMatchedCount(Lotto lotto, List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(lotto.getNumbers() :: contains)
                .count();
    }

    private static Rank calculateRank(Integer matchedCount, boolean containBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchedCount == matchedCount)
                .filter(rank -> rank.containBonus == containBonus)
                .findAny()
                .orElse(NONE);
    }
}
