package lotto.model;

import java.util.Arrays;
import java.util.List;

public enum WinningRank {
    FIRST(6, List.of(true, false), 2_000_000_000, "6개 일치"),
    SECOND(5, List.of(true), 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, List.of(false), 1_500_000, "5개 일치"),
    FOURTH(4, List.of(true, false), 50_000, "4개 일치"),
    FIFTH(3, List.of(true, false), 5_000, "3개 일치"),
    ETC(0, List.of(), 0, "");

    private int match;
    private List<Boolean> hasBonus;
    private int reward;
    private String message;

    WinningRank(int match, List<Boolean> hasBonus, int reward, String message) {
        this.match = match;
        this.hasBonus = hasBonus;
        this.reward = reward;
        this.message = message;
    }

    public static WinningRank getWinningRank(int matchCount, boolean hasBonus) {
        return Arrays.stream(WinningRank.values())
                .filter(rank -> rank.match == matchCount)
                .filter(rank -> rank.hasBonus.contains(hasBonus))
                .findAny()
                .orElse(ETC);
    }

    public int getReward() {
        return reward;
    }

}
