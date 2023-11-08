package lotto.service;

import lotto.dto.MoneyDTO;
import lotto.dto.WinningStatisticDTO;

public interface CalculateLotteryService {
    WinningStatisticDTO countMatchesNumber();
    MoneyDTO calculateReturnRates(MoneyDTO moneyDTO, WinningStatisticDTO winningStatisticDTO);
}
