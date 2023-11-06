package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    private WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public static WinningLotto from(List<Integer> numbers) {
        return new WinningLotto(numbers);
    }
}
