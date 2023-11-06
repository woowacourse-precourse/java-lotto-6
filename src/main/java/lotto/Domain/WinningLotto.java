package lotto.Domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> normalNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> normalNumbers, int bonusNumber) {
        this.normalNumbers = normalNumbers;
        this.bonusNumber = bonusNumber;
    }
}
