package lotto.service.input;

import lotto.dto.input.GetBonusNumberDto;
import lotto.dto.input.GetLottoCountDto;
import lotto.dto.input.GetWinningNumberDto;

public interface Input {
    GetLottoCountDto getLottoBuyMoney();
    GetWinningNumberDto getWinningNumber();
    GetBonusNumberDto getBonusNumber(GetWinningNumberDto getWinningNumberDto);
}
