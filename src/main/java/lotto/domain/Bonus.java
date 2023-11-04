package lotto.domain;

import lotto.util.CommonInputValidator;

import java.util.List;

public class Bonus {
    private static final String IS_NOT_OVERLAP_BONUS_VALIDATOR_ERROR_MESSAGE = "[ERROR] 보너스 번호와 중복된 로또 번호가 존재합니다.";
    private final Integer number;
    public Bonus(List<Integer> sixNumbers, Integer number){
        isNotOverlapBonusValidator(sixNumbers, number);
        CommonInputValidator.isInRangeValidator(number);
        this.number = number;
    }

    private void isNotOverlapBonusValidator(List<Integer> numbers, Integer bonusNumber){
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException(IS_NOT_OVERLAP_BONUS_VALIDATOR_ERROR_MESSAGE);
        }
    }
}
