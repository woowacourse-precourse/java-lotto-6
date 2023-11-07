package lotto.domain;

import java.util.List;
import lotto.domain.Lotto;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(Lotto lotto) {
        numbers = lotto.getLotto();
    }

    public List<Integer> getWinningNumber() {
        return numbers;
    }
}
