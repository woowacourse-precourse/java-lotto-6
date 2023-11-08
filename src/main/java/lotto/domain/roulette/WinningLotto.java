package lotto.domain.roulette;

import lotto.domain.lotto.Lotto;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateContainNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto lotto, int bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    public Lotto getNumbers() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void validateContainNumber(Lotto lotto, int bonusNumber) {
        if (lotto.isContainNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호에 포함된 숫자입니다. 다시 입력해주세요.");
        }
    }

    public void validateNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 이내의 숫자만 입력해주세요.");
        }
    }
}
