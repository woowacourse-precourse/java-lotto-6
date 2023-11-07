package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;

    public WinningLotto(List<Integer> integers) {
        this.numbers = integers;
    }
}
