package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final Number bonusNumber;

    public WinningLotto(Lotto inputLottoNumbers, Number inputBonusNumber) {
        validateDuplicated(inputLottoNumbers, inputBonusNumber);
        this.lotto = inputLottoNumbers;
        this.bonusNumber = inputBonusNumber;
    }


    private void validateDuplicated(Lotto lotto, Number bonusNumber) {
        boolean contains = lotto.contains(bonusNumber);
        if (contains) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 겹칩니다!");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Number getBonusNumber() {
        return bonusNumber;
    }
}
