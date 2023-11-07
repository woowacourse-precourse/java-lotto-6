package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputMaker {

    private static final String NUMBERS_PREFIX = "[";
    private static final String NUMBERS_SUFFIX = "]";
    private static final String DELIMITER = ", ";
    private static final String NEW_LINE = "\n";

    public String makeLottosNumbersOutput(List<List<Integer>> lottosNumbers) {
        return lottosNumbers.stream()
            .map(this::makeLottoNumbersOutput)
            .collect(Collectors.joining(NEW_LINE));
    }

    private String makeLottoNumbersOutput(List<Integer> numbers) {
        return numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(DELIMITER, NUMBERS_PREFIX, NUMBERS_SUFFIX));
    }
}
