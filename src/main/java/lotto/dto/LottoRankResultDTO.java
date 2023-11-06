package lotto.dto;

import lotto.model.LottoRank;
import lotto.model.LottoRankResult;

public record LottoRankResultDTO(LottoRank rank, LottoRankResult result) {
    public String getRankMessage() {
        return rank.getMessage();
    }

    public int getCount() {
        return result.getCountByLottoRank(rank);
    }
}
