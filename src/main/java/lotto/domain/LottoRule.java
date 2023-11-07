package lotto.domain;

import java.util.List;

public class LottoRule {
    public static final int LENGTH = 6;
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;



    protected boolean isMismatchLength(List<Integer> numbers) {
        if (numbers.size() != LENGTH) {
            return true;
        }
        return false;
    }

    protected boolean isDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            return true;
        }
        return false;
    }

    protected boolean isOutOfRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_RANGE || number > MAX_RANGE) {
                return true;
            }
        }
        return false;
    }

}
