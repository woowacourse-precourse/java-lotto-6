package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto{

    private final int bonusNum;

    public WinningLotto(List<Integer> numbers, int bonusNum) {
        super(numbers);
        this.bonusNum = bonusNum;
    }
}
