package lotto.validation;

import static lotto.constant.ErrorMessage.INVALID_DUPLICATE_LOTTO_NUM;
import static lotto.constant.ErrorMessage.INVALID_RANGE_LOTTO_NUM;
import static lotto.constant.Message.LOTTO_NUM_RANGE_MAX;
import static lotto.constant.Message.LOTTO_NUM_RANGE_MIN;

import java.util.List;
import java.util.Set;

public class LottoValidation {

    public void validate_isNotDuplicate(List<Integer> nums){
        if(Set.copyOf(nums).size() != nums.size()){
            throw new IllegalArgumentException(INVALID_DUPLICATE_LOTTO_NUM);
        }
    }

    public void validate_isLottoRangeNum(List<Integer> nums){
        for (Integer num : nums){
            if(num < LOTTO_NUM_RANGE_MIN || num > LOTTO_NUM_RANGE_MAX){
                throw new IllegalArgumentException(INVALID_RANGE_LOTTO_NUM);
            }
        }
    }

}
