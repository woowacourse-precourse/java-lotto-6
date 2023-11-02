package lotto.dto;

import java.util.List;

public class WinningNumbersDto {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbersDto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}