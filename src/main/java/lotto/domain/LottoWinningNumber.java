package lotto.domain;

import java.util.List;

public class LottoWinningNumber {
    private Lotto lotto;
    private int bonusNumber;

    public LottoWinningNumber() {}

    public List<Integer> getNumbers() {
        return this.lotto.getNumbers();
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    /**
     * 로또 객체를 받아 보너스 번호와 중복되는지 검증한 뒤,
     * 당첨 번호로 설정한다.
     * @param lotto 로또 객체
     */
    public void setLotto(Lotto lotto) {
        validateDuplication(lotto);
        this.lotto = lotto;
    }

    /**
     * 보너스 번호를 입력받아 유효한 로또 번호인지 검증하고
     * 로또 당첨 번호와 겹치지 않은지 검증한 뒤,
     * 당첨 로또의 보너스 번호로 설정한다.
     * @param bonusNumber 보너스 번호
     */
    public void setBonusNumber(int bonusNumber) {
        validateRangeOfNumbers(bonusNumber);
        validateDuplication(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateRangeOfNumbers(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하의 숫자여야 합니다.");
        }
    }

    private void validateDuplication(int bonusNumber) {
        if (this.lotto == null) { return; }
        if (this.lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    private void validateDuplication(Lotto lotto) {
        if (lotto.getNumbers().contains(this.bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }
}
