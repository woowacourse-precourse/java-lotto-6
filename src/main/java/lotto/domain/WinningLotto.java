package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto{

    static final String BONUS_NUMBER_DUPLICATED_EXCEPTION_MASSAGE = "[ERROR] 보너스 번호는 당첨번호와 겹치지 않는 숫자여야 합니다.";
    static final String BONUS_NUMBER_RANGE_EXCEPTION_MASSAGE = "[ERROR] 보너스 번호는 1~45 사이여야 합니다.";

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);

        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (!isInLottoRange(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_EXCEPTION_MASSAGE);
        }
        if (super.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_EXCEPTION_MASSAGE);
        }
    }
}
