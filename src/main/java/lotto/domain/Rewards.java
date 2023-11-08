package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rewards {
    First(6, null, 2_000_000_000),
    Second(5, true, 30_000_000),
    Third(5, false, 1_500_000),
    Fourth(4, null, 50_000),
    Fifth(3, null, 5_000);

    private final int countOfMatch;
    private final Boolean isBonusMatch;
    private final int prize;

    Rewards(int match, Boolean bonus, int prize) {
        this.countOfMatch = match;
        this.isBonusMatch = bonus;
        this.prize = prize;
    }

    public String getSummaryText() {
        return getMatchText() + getBonusText() + getPrizeText();
    }

    public static Optional<Rewards> getRewardByValues(int matches, boolean bonus) {
        return Arrays.stream(Rewards.values())
                .filter(reward -> (reward.countOfMatch == matches)
                        && (reward.isBonusMatch == null || reward.isBonusMatch == (Boolean) bonus))
                .findFirst();
    }

    public int getPrize() {
        return this.prize;
    }

    private String getMatchText() {
        String COUNT_OF_MATCH_TEXT = "개 일치";
        return this.countOfMatch + COUNT_OF_MATCH_TEXT;
    }

    private String getBonusText() {
        if (this.countOfMatch == 5 && this.isBonusMatch) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    private String getPrizeText() {
        return String.format(" (%,d원)", this.prize);
    }
}
