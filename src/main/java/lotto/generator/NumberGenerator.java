package lotto.generator;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGenerator {
    private static final int STARTING_RANGE = 1;
    private static final int END_RANGE = 45;
    public static List<Integer> generateAllNumbers() {
        return IntStream.rangeClosed(STARTING_RANGE, END_RANGE)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> generateFilteredNumbers(List<Integer> allNumbers, List<Integer> excludedNumbers) {
        return allNumbers.stream()
                .filter(number -> !excludedNumbers.contains(number))
                .toList();
    }

}
