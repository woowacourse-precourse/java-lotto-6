package lotto.domain;

import java.util.List;

public class Game {
    private final List<Number> winningNumbers;
    private final int bonusNumber;

    public Game(List<Number> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
