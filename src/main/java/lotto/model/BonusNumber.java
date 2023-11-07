package lotto.model;

import java.util.List;

public class BonusNumber {
    public void isSameNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자가 당첨 숫자와 일치합니다.");
        }
    }
}
