package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ExceptionMessage;
import lotto.util.NumberConverter;

public class WinningNumbers {
    private static final String COMMA_DELIMITER = ",";
    private final NumberConverter numberConverter;

    public WinningNumbers(NumberConverter numberConverter) {
        this.numberConverter = numberConverter;
    }

    public List<Integer> process(String numbers) {
        validateCommas(numbers);
        List<String> trimmed = trimList(splitByComma(numbers));
        return convertNumber(trimmed);
    }

    private void validateCommas(String numbers) {
        if (numbers.startsWith(COMMA_DELIMITER) || numbers.endsWith(COMMA_DELIMITER) || numbers.contains(
                COMMA_DELIMITER + COMMA_DELIMITER)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_COMMA_USAGE.getMessage());
        }
    }

    private List<String> splitByComma(String numbers) {
        return Arrays.asList(numbers.split(COMMA_DELIMITER));
    }

    private List<String> trimList(List<String> lottonNumbers) {
        List<String> trimmed = new ArrayList<>();
        for (String name : lottonNumbers) {
            trimmed.add(name.trim());
        }
        return trimmed;
    }

    private List<Integer> convertNumber(List<String> trimmed) {
        return trimmed.stream()
                .map(String::trim)
                .map(numberConverter::convert)
                .collect(Collectors.toList());
    }

}