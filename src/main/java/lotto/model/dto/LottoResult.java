package lotto.model.dto;

import java.util.Arrays;
import java.util.List;
import lotto.model.calculate.MarginRate;
import lotto.model.calculate.WinningResult;
import lotto.model.enums.LottoPlace;

public class LottoResult {
    private final List<WinningResultDto> winningResultDtos;
    private final MarginRateDto marginRateDto;

    public LottoResult(WinningResult winningResult, MarginRate marginRate) {
        this.winningResultDtos = generateWinningResultDtos(winningResult);
        this.marginRateDto = new MarginRateDto(marginRate);
    }

    public List<WinningResultDto> getWinningResultDtos() {
        return winningResultDtos;
    }

    public MarginRateDto getMarginRateDto() {
        return marginRateDto;
    }

    private List<WinningResultDto> generateWinningResultDtos(WinningResult winningResult) {
        return Arrays.stream(LottoPlace.values())
                .map(lottoPlace -> mapWinningResultDto(winningResult, lottoPlace))
                .toList();
    }

    private WinningResultDto mapWinningResultDto(WinningResult winningResult, LottoPlace lottoPlace) {
        Integer countLottos = winningResult.getCount(lottoPlace);
        return new WinningResultDto(lottoPlace, countLottos);
    }
}
