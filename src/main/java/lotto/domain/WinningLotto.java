package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNum;

    public WinningLotto(List<Integer> integers, int bonusNum) {
        this.numbers = integers;
        this.bonusNum = bonusNum;
    }
}
