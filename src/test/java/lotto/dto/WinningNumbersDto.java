package lotto.dto;

import java.util.List;
import lotto.domain.winning.WinningNumbers;

public class WinningNumbersDto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbersDto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers toWinningTicket() {
        return new WinningNumbers(winningNumbers, bonusNumber);
    }
}
