package lotto.controller.dto.output;

import java.util.Collections;
import java.util.List;
import lotto.common.constants.LottoRank;

public record WinningLottoResultDto(List<LottoRank> winningResult, double profitRate) {
    public WinningLottoResultDto(List<LottoRank> winningResult, double profitRate) {
        this.winningResult = Collections.unmodifiableList(winningResult);
        this.profitRate = profitRate;
    }
}
