package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {
    private static final String REGEX = ",";

    public static Lotto createLottoFrom(final String input) {
        List<Integer> numbers = Arrays.stream(input.split(REGEX))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }
}
