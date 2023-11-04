package Model;

import Model.Constant.Constants;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate1to45(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validate1to45(int bonusNumber) {
        if (bonusNumber < Constants.MIN_NUM || bonusNumber > Constants.MAX_NUM) {
            throw new IllegalArgumentException(
                    "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void validateAlreadyExist(Lotto lotto) {
        for (int i = 0; i < lotto.getSize(); i++) {
            if (bonusNumber == lotto.getItem(i)) {
                throw new IllegalArgumentException(
                        "[ERROR] 보너스 번호는 로또 번호와 겹치지 않아야 합니다.");
            }
        }
    }

    public int get() {
        return bonusNumber;
    }
}
