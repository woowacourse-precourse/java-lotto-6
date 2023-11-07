package lotto.service;

import java.util.List;
import lotto.domain.WinningNumber;

public class WinningService {
    public WinningNumber createWinningNumber(List<Integer> numbers, int bonusNumber) {
        return new WinningNumber(numbers, bonusNumber);
    }
}
