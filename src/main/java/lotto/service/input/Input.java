package lotto.service.input;

import lotto.dto.input.GetBonusNumberDto;
import lotto.dto.input.GetLottoBuyMoneyDto;
import lotto.dto.input.GetWinningNumberDto;

public interface Input {
    GetLottoBuyMoneyDto getLottoBuyMoney();
    GetWinningNumberDto getWinningNumber();
    GetBonusNumberDto getBonusNumber();
}
