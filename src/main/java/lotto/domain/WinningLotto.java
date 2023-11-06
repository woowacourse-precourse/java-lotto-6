package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final Number bonusNumber;

    public WinningLotto(Lotto lotto, Number bonusNumber) {
        validateDuplicated(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public void validateDuplicated(Lotto lotto, Number bonusNumber) {
        boolean contains = lotto.contains(bonusNumber);
        if (contains) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 겹칩니다!");
        }
    }

}
