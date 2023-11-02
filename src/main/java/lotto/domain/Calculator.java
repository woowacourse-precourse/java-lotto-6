package lotto.domain;

import java.util.List;

public class Calculator {
    final Lottos lottos;
    final List<Integer> winningNumbers;
    final int bonusNumber;

    public Calculator(Lottos lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
