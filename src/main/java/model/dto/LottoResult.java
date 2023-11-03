package model.dto;

import model.LottoRank;

public record LottoResult(int equalCount, boolean hasBonusBall, long reward, int count) {

    public static LottoResult of(LottoRank rank, int count) {
        return new LottoResult(rank.getEqualCount(), rank.getBonusBallCondition(),
            rank.getReward(), count);
    }
}
