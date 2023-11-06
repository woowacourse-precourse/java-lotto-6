package lotto.service.resultcheck;

import lotto.dto.calculate.GetLottoResultDto;
import lotto.dto.domain.lottos.GetLottosDto;
import lotto.dto.input.GetBonusNumberDto;
import lotto.dto.input.GetWinningNumberDto;

public interface ResultCheck {
    GetLottoResultDto getLottoResult(GetWinningNumberDto getWinningNumberDto, GetBonusNumberDto getBonusNumberDto, GetLottosDto getLottosDto);
}
