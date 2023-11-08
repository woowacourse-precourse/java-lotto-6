package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {
    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public List<Integer> getNumbers() {
        return super.getUnmodifiableNumbers();
    }
}
