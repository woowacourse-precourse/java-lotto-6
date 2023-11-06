package lotto.util;

import java.util.HashSet;
import java.util.List;

import static lotto.util.ErrorProperties.*;

public class ListUtil {
    public static void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException(getErrorMessageDuplication());
        }
    }
}
