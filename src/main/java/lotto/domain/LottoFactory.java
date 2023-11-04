package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.NumberUtil;

public class LottoFactory {
    private static final String REGEX = ",";

    public static Lotto createLottoFrom(final String input) {
        List<Integer> numbers = Arrays.stream(input.split(REGEX))
                .map(NumberUtil::parseInt)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }
}
