package lotto.domain;

import java.util.Collections;
import lotto.dto.WinningNumbersDto;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = Collections.unmodifiableList(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbersDto toDto() {
        return new WinningNumbersDto(winningNumbers, bonusNumber);
    }
}