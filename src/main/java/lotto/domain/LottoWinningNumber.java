package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoWinningNumber {
    private Lotto lotto;
    private int bonusNumber;

    public LottoWinningNumber() {}
    public void setLotto(Lotto lotto) {
        validateDuplicationBetweenLottoAndBonusNumber(lotto);
        this.lotto = lotto;
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        validateDuplicationBetweenLottoAndBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하의 숫자여야 합니다.");
        }
    }

    private void validateDuplicationBetweenLottoAndBonusNumber(int bonusNumber) {
        if (this.lotto == null) { return; }
        if (this.lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    private void validateDuplicationBetweenLottoAndBonusNumber(Lotto lotto) {
        if (lotto.getNumbers().contains(this.bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return this.lotto.getNumbers();
    }
    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
