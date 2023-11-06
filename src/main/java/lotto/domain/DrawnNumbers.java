package lotto.domain;

import java.util.List;
import lotto.dto.DrawnNumbersDto;

public class DrawnNumbers {
    private final List<Integer> winningNumbers;

    private final Integer bonusNumber;

    private DrawnNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static DrawnNumbers from(DrawnNumbersDto drawnNumbersDto) {
        return new DrawnNumbers(drawnNumbersDto.getWinningNumbers(), drawnNumbersDto.getBonusNumber());
    }
}
