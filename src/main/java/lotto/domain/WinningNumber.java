package lotto.domain;

import java.util.List;
import lotto.Lotto;

public class WinningNumber {

    private Lotto winningLotto;
    private int bonusNumber;

    public void createWinningNumber(List<Integer> numbers) {
        winningLotto = new Lotto(numbers);
    }
}
