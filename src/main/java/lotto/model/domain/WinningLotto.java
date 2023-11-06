package lotto.model.domain;

import java.util.List;

public class WinningLotto {

    private final List<Integer> numbers;

    public WinningLotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
