package lotto.model;

import java.util.List;

public class BonusNumber {
    public void isSameNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자가 당첨 숫자와 일치합니다.");
        }
    }

    public void isCorrectRange(int bonusNumber){
        if(bonusNumber<1 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 숫자가 1부터 45사이의 숫자가 아닙니다.");
        }
    }
}
