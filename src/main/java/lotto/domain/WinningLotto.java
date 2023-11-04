package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;

    public WinningLotto(List<String> numbers) {
        this.numbers = numbers.stream()
                .map(Integer::valueOf)
                .toList();
    }
}
