package lotto.model;

import java.util.*;

/**
 * @Enum : 로또 당첨 기준 열거형
 */
public enum LottoRank {
    FIRST_RANK(6, 2000000000, false),
    SECOND_RANK(5, 30000000, true),
    THIRD_RANK(5, 1500000, false),
    FOURTH_RANK(4, 50000, false),
    FIFTH_RANK(3, 5000, false),
    ;

    private final int count;
    private final int reward;
    private final boolean hasBonusNumber;

    LottoRank(int count, int reward, boolean hasBonusNumber) {
        this.count = count;
        this.reward = reward;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static LottoRank findRank(int count, boolean hasBonusNumber) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getCount() == count)
                .filter(rank -> rank.hasBonusNumber() == hasBonusNumber)
                .findFirst()
                .orElse(null);
    }

    public static List<LottoRank> getAllRank() {
        return new ArrayList<>(Arrays.asList(LottoRank.values()));
    }

    public int getCount() {
        return count;
    }

    public int getReward() {
        return reward;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}