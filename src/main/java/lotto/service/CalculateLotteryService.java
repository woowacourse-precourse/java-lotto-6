package lotto.service;

import lotto.dto.MoneyDTO;
import lotto.dto.WinningStatisticDTO;

public interface CalculateLotteryService {
    public WinningStatisticDTO countMatchesNumber();
    public MoneyDTO calculateReturnRates(WinningStatisticDTO winningStatisticDTO);
}
