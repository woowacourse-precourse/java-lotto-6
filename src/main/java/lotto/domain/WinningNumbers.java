package lotto.domain;

import java.util.List;

public final class WinningNumbers {

    private final Lotto lotto;

    public WinningNumbers(final List<Integer> numbers) {
        this.lotto = new Lotto(numbers);
    }
}
