package lotto.domain;

import java.util.List;
import lotto.util.LottoConstants;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (!LottoConstants.isNumberInRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public boolean isContains(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
