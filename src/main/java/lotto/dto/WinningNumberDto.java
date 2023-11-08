package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;

public class WinningNumberDto {
    private WinningNumber winningNumber;

    public WinningNumberDto(WinningNumber winningNumber){
        this.winningNumber = winningNumber;
    }
    public WinningNumber getWinningNumber() {
        return winningNumber;
    }
}
