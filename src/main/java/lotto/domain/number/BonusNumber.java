package lotto.domain.number;

import static lotto.domain.number.LottoRandomNumber.LIMIT_RANGE;
import static lotto.domain.number.LottoRandomNumber.START_RANGE;

import lotto.domain.lotto.WinningLotto;
import lotto.dto.request.BonusNumberRequest;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(BonusNumberRequest bonusNumber, WinningLotto winningLotto) {
        this.bonusNumber = validateType(bonusNumber);
        validateRange();
        winningLotto.validateIsDuplicate(this.bonusNumber);
    }

    private int validateType(BonusNumberRequest bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber.getBonusNumber());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 타입 입니다.");
        }
    }

    private void validateRange() {
        if (bonusNumber < START_RANGE || LIMIT_RANGE < bonusNumber) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 수를 입력해주세요.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}