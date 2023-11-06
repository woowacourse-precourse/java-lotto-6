package lotto.model;

import static lotto.model.Lotto.LOTTO_MAX_NUMBER;
import static lotto.model.Lotto.LOTTO_MIN_NUMBER;

public class User {
    private final Lotto lotto;
    private final int bonusNumber;

    public User(Lotto lotto, int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < bonusNumber) {
            throw new IllegalArgumentException("로또 숫자의 범위는 1~45입니다.");
        }
    }

    private void validateDuplicate(Lotto lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 숫자는 중복될 수 없습니다.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
