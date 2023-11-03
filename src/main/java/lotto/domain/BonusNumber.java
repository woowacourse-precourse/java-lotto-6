package lotto.domain;

import java.util.List;

public class BonusNumber {

    public void validateDuplicateBonusNumber(List<Integer> answerNumber, int bonusNumber) {
        if(answerNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] : 정답 번호와 동일한 보너스 번호가 있으면 안됩니다.");
        }
    }
}
