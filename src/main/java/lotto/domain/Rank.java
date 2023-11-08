package lotto.domain;

import java.util.Arrays;
import java.util.StringJoiner;

public enum Rank {
    FIFTH(3, false, 5000, "(5,000원)"),
    FOURTH(4, false, 50000, "(50,000원)"),
    THIRD(5, false, 1500000, "(1,500,000원)"),
    SECOND(5, true, 30000000, "(30,000,000원)"),
    FIRST(6, false, 2000000000, "(2,000,000,000원)");

    private static final String CORRECT_MESSAGE = "%s개 일치";
    private static final String BONUS_NUMBER_MESSAGE = ", 보너스 볼 일치";
    private static final String EMPTY_SPACE = " ";

    private final int matchCount;
    private final boolean isMatchBonusNumber;
    private final long reward;
    private final String rewardMessage;

    Rank(int matchCount, boolean isMatchBonusNumber, long reward, String rewardMessage) {
        this.matchCount = matchCount;
        this.isMatchBonusNumber = isMatchBonusNumber;
        this.reward = reward;
        this.rewardMessage = rewardMessage;
    }

    public static Rank getRank(int matchCount, boolean isMatchBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter((rank) -> rank.isSameRank(matchCount, isMatchBonusNumber))
                .findFirst().orElse(null);
    }

    private boolean isSameRank(int matchCount, boolean isMatchBonusNumber) {
        return this.matchCount == matchCount && this.isMatchBonusNumber == isMatchBonusNumber;
    }

    public long getRankReward(long count) {
        return reward * count;
    }

    public String getRankMessage() {
        StringJoiner stringJoiner = new StringJoiner(EMPTY_SPACE);
        stringJoiner.add(String.format(getRankInformationMessage(), matchCount));
        stringJoiner.add(rewardMessage);

        return stringJoiner.toString();
    }

    private String getRankInformationMessage() {
        if (isMatchBonusNumber) {
            return CORRECT_MESSAGE + BONUS_NUMBER_MESSAGE;
        }
        return CORRECT_MESSAGE;
    }
}
