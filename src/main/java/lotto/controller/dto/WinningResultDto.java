package lotto.controller.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.result.WinningRank;

public class WinningResultDto {

    private final Map<String, LottoInfoDto> winningResult;

    private WinningResultDto(Map<String, LottoInfoDto> winningResult) {
        this.winningResult = winningResult;

    }

    public static WinningResultDto of(Map<WinningRank, Integer> result) {
        Map<String, LottoInfoDto> winningResult = new LinkedHashMap<>();
        winningResult.put("fifth", LottoInfoDto.of(result, WinningRank.FIFTH));
        winningResult.put("fourth", LottoInfoDto.of(result, WinningRank.FOURTH));
        winningResult.put("third", LottoInfoDto.of(result, WinningRank.THIRD));
        winningResult.put("second", LottoInfoDto.of(result, WinningRank.SECOND));
        winningResult.put("first", LottoInfoDto.of(result, WinningRank.FIRST));
        return new WinningResultDto(winningResult);
    }

    public Map<String, LottoInfoDto> getWinningResult() {
        return winningResult;
    }
}
