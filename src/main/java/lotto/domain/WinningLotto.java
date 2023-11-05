package lotto.domain;

import java.util.List;

public class WinningLotto {

    private Lotto lotto;
    private int bonusNumber;

    public void generate(List<Integer> numbers) {
        lotto = new Lotto(numbers);
    }
}
