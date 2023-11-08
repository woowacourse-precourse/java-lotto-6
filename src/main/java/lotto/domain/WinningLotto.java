package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final List<Integer> numbers;
    int bonusNumber;

    public WinningLotto(List<Integer> numbers, int number) {
        this.numbers = numbers;
        this.bonusNumber = number;
    }
}
