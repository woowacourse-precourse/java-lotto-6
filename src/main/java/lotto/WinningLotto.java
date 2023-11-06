package lotto;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonus;

    public WinningLotto(List<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }
}
