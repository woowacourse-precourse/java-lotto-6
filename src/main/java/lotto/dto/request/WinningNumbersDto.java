package lotto.dto.request;

import java.util.List;

public class WinningNumbersDto {
    private final List<Integer> winningNumbers;

    public WinningNumbersDto(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
