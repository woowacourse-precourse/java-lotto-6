package lotto.domain.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.constants.ValidateConstants;

public class LottoValidator implements Validator<List<Integer>> {
    @Override
    public void validate(List<Integer> lottoNumber) {
        validateRange(lottoNumber);
        validateDuplication(lottoNumber);
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbers.size() != numbersSet.size()) {
            throw new IllegalArgumentException(ValidateConstants.LOTTO_NUMBER_DUPLICATION_ERROR.getConstants());
        }
    }

    private void validateRange(List<Integer> numbers) {
        int min = ValidateConstants.LOTTO_MIN_NUMBER.getNumberConstants();
        int max = ValidateConstants.LOTTO_MAX_NUMBER.getNumberConstants();

        boolean isInvalidRange = numbers.stream()
                .anyMatch(number -> number < min || number > max);
        if (isInvalidRange) {
            throw new IllegalArgumentException(ValidateConstants.LOTTO_NUMBER_RANGE_ERROR.getConstants());
        }
    }
}
