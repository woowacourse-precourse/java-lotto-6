package lotto.dto;

import java.util.List;
import lotto.domain.WinningNumber;

public record WinningNumberDto(List<Integer> winningNumbers, int bonusNumber) {

    public WinningNumber toValueObject() {
        return WinningNumber.of(winningNumbers, bonusNumber);
    }
}
