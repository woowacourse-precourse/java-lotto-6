package model.dto;

import model.LottoRank;

public record LottoResult(int equalCount, boolean hasBonusBall, long reward, int count) {

    public static LottoResult of(final LottoRank rank, final int count) {
        return new LottoResult(rank.getEqualCount(), rank.mustSameBonusBall(),
            rank.getReward(), count);
    }
}
