package lotto.domain;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

enum LottoPrize {

    FIRST(6, 2_000_000_000, "6개 일치", false),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치", true),
    THIRD(5, 1_500_000, "5개 일치", false),
    FOURTH(4, 50_000, "4개 일치", false),
    FIFTH(3, 5_000, "3개 일치", false),
    LOSE(0, 0, "낙첨", false);

    private final static Map<Map.Entry<Integer, Boolean>, LottoPrize> prizeClassifier = new HashMap<>();

    static {
        prizeClassifier.put(new AbstractMap.SimpleEntry<>(FIRST.matchCount, FIRST.isBonusIncluded), FIRST);
        prizeClassifier.put(new AbstractMap.SimpleEntry<>(SECOND.matchCount, SECOND.isBonusIncluded), SECOND);
        prizeClassifier.put(new AbstractMap.SimpleEntry<>(THIRD.matchCount, THIRD.isBonusIncluded), THIRD);
        prizeClassifier.put(new AbstractMap.SimpleEntry<>(FOURTH.matchCount, FOURTH.isBonusIncluded), FOURTH);
        prizeClassifier.put(new AbstractMap.SimpleEntry<>(FIFTH.matchCount, FIFTH.isBonusIncluded), FIFTH);
    }

    private final int matchCount;
    private final int reward;
    private final String ruleDescription;
    private final boolean isBonusIncluded;

    LottoPrize(int matchCount, int reward, String ruleDescription, boolean isBonusIncluded) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.ruleDescription = ruleDescription;
        this.isBonusIncluded = isBonusIncluded;
    }

    public static LottoPrize of(int matchCount, boolean isBonusIncluded) {
        return prizeClassifier.getOrDefault(new AbstractMap.SimpleEntry<>(matchCount, isBonusIncluded), LOSE);
    }

    public int getReward() {
        return reward;
    }

    public String getRuleDescription() {
        return ruleDescription;
    }
}
