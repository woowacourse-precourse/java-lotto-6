package lotto.generator;


import static lotto.globar.GlobalConstants.LOTTO_END_RANGE;
import static lotto.globar.GlobalConstants.LOTTO_STARTING_RANGE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.globar.GlobalConstants;

public class NumberGenerator {
    public static List<Integer> generateAllLottoNumbers() {
        return IntStream.rangeClosed(LOTTO_STARTING_RANGE, LOTTO_END_RANGE)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> generateFilteredNumbers(List<Integer> allNumbers, List<Integer> excludedNumbers) {
        return allNumbers.stream()
                .filter(number -> !excludedNumbers.contains(number))
                .toList();
    }

}
