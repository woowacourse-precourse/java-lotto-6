package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    private WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    private WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto create(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }
}
