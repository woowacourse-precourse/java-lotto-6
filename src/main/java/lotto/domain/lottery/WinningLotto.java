package lotto.domain.lottery;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;

    public WinningLotto(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
