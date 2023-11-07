package lotto.utils;

import lotto.constants.ErrorConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ListUtil {
    private static void checkDuplicateValue(List<Objects> numbers) {
        Set<Objects> set = new HashSet<>(numbers);
        if(numbers.size() != set.size()) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_LOTTO_DUPLICATED_VALUE.getData());
        }
    }
    private static void checkLength(List<Objects> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_LOTTO_INVALID_LENGTH.getData());
        }
    }
    private static void checkRange(List<Integer> numbers) {
        for(int num : numbers) {
            if( num <0 || num >46)
                throw new IllegalArgumentException(ErrorConstants.ERROR_LOTTO_INVALID_RANGE.getData());
        }
    }
}
