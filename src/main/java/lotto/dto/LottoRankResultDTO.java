package lotto.dto;

import lotto.model.rank.LottoRank;
import lotto.model.rank.LottoRankResult;

public record LottoRankResultDTO(LottoRank rank, LottoRankResult result) {
    public String getRankMessage() {
        return rank.getMessage();
    }

    public int getCount() {
        return result.getCountByLottoRank(rank);
    }
}
