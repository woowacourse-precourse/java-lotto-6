package lotto.dto;

import java.util.EnumMap;
import lotto.constants.LottoReward;

public record WinningResultDto(EnumMap<LottoReward, Integer> winningResult) {

    public int getWinningCount(LottoReward lottoReward){
        return winningResult.get(lottoReward);
    }
}
