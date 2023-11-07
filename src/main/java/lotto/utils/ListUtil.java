package lotto.utils;

import lotto.constants.ErrorConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ListUtil {
    public static void checkDuplicateValue(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(numbers.size() != set.size()) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_LOTTO_DUPLICATED_VALUE.getData());
        }
    }
    public static void checkLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_LOTTO_INVALID_LENGTH.getData());
        }
    }
    public static void checkRange(List<Integer> numbers) {
        for(int num : numbers) {
            if( num <0 || num >46)
                throw new IllegalArgumentException(ErrorConstants.ERROR_LOTTO_INVALID_RANGE.getData());
        }
    }
}
