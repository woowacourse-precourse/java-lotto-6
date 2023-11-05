package lotto.dto;

import lotto.constant.Rank;

public record ResultDto(
        int sameNumberCount,
        boolean hasBonus,
        int reward,
        Long count
) implements Comparable<ResultDto> {

    public static ResultDto of(final Rank rank, final Long count) {
        return new ResultDto(rank.getSameNumberCount(),
                rank.isNeedBonus(),
                rank.getReward(),
                count);
    }

    @Override
    public int compareTo(ResultDto o) {
        return Integer.compare(reward, o.reward);
    }
}