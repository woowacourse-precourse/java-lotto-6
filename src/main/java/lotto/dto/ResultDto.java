package lotto.dto;

import lotto.constant.Rank;

public class ResultDto implements Comparable<ResultDto> {
    private final int sameNumberCount;
    private final boolean hasBonus;
    private final int reward;
    private final Long count;

    private ResultDto(int sameNumberCount, boolean hasBonus, int reward, Long count) {
        this.sameNumberCount = sameNumberCount;
        this.hasBonus = hasBonus;
        this.reward = reward;
        this.count = count;
    }

    public static ResultDto of(Rank rank, Long count) {
        return new ResultDto(rank.getSameNumberCount(),
                rank.isNeedBonus(),
                rank.getReward(),
                count);
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public boolean isHasBonus() {
        return hasBonus;
    }

    public int getReward() {
        return reward;
    }

    public Long getCount() {
        return count;
    }

    @Override
    public int compareTo(ResultDto o) {
        return Integer.compare(reward, o.reward);
    }
}