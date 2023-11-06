package lotto.validation;

import java.util.List;
import lotto.utils.constant.LottoConstant;
import lotto.utils.message.ErrorMessage;

public class BonusNumberValidation {
    public void validate(List<Integer> nums, int n) {
        validateRange(n);
        validateDuplicated(nums, n);
    }

    private void validateRange(int n) {
        if (n < LottoConstant.LOTTO_NUMBER_MIN || n > LottoConstant.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE);
        }
    }

    private void validateDuplicated(List<Integer> nums, int n) {
        nums.forEach(i -> validateDuplicated(i, n));
    }

    private void validateDuplicated(int n1, int n2) {
        if (n1 == n2) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER);
        }
    }
}
