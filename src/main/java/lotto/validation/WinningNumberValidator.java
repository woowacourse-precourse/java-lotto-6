package lotto.validation;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumberValidator {
    private static final int MINIMUM_WINNING_NUMBER = 1;
    private static final int MAXIMUM_WINNING_NUMBER = 45;
    private static final int WINNING_NUMBERS_COUNT = 6;



    private static Set<Integer> parseToIntSet(String winningNumbers) {
        try {
            return Stream.of(winningNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.", exception);
        }
    }


}
