package lotto.dto;

import lotto.constant.LottoWinningRank;

import java.util.List;

public record LottoWinningResult(
        List<LottoWinningRank> winningRanks,
        double totalReturnRate
) {
}
