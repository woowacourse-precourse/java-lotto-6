package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> winningLottoNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.winningLottoNumbers = numbers;
        this.bonusNumber = bonusNumber;
    }
}
