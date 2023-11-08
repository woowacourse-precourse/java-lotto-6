package lotto.dto;

import java.util.List;

public record LottoResultDTO(List<LottoWinningResultDTO> lottoWinningResultDTOs,
                             LottoReturnsRateDTO lottoReturnsRateDTO) {
}
