package lotto;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(Lotto lotto) {
        numbers = lotto.getLotto();
    }

    public List<Integer> getWinningNumber() {
        return numbers;
    }
}
