package lotto.validation;

import static lotto.constant.ErrorMessage.INVALID_DUPLICATE_LOTTO_NUM;

import java.util.List;
import java.util.Set;

public class LottoValidation {

    public void validate_isNotDuplicate(List<Integer> nums){
        if(Set.copyOf(nums).size() != nums.size()){
            throw new IllegalArgumentException(INVALID_DUPLICATE_LOTTO_NUM);
        }
    }
}
