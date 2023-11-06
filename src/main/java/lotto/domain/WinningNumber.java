package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class WinningNumber {

    private Lotto lotto;
    private int bonusNumber;

    public WinningNumber(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        if(bonusNumber <1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
        if(lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스는 로또 번호와 중복될 수 없습니다.");
        }
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lotto.getNumbers());
    }
}
