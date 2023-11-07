package lotto.domain.parser;

import static lotto.ErrorMessage.LOTTO_WRONG_INPUT_ERROR_MESSAGE;
import static lotto.ErrorMessage.PARSE_INT_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class LottoInputParser extends InputParser {

    private static final String DELIMITER = ",";
    private static final Pattern PATTERN = Pattern.compile("^\\d+(,\\d+)*$");

    @Override
    public List<Integer> parse(String input) {
        validate(input);
        removeSpaces(input);
        return parseStringListToIntegerList(split(input));
    }

    @Override
    public void validate(String input) {
        if (!isNumericWithCommaDelimiter(input)) {
            throwException(LOTTO_WRONG_INPUT_ERROR_MESSAGE.get());
        }
    }

    private List<String> split(String input) {
        return Arrays.stream(input.split(DELIMITER)).toList();
    }

    private boolean isNumericWithCommaDelimiter(String input) {
        return PATTERN.matcher(input).matches();
    }

    private List<Integer> parseStringListToIntegerList(List<String> input) {
        List<Integer> result = new ArrayList<>();
        for (String str : input) {
            try {
                int value = Integer.parseInt(str);
                result.add(value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(PARSE_INT_ERROR_MESSAGE.get());
            }
        }
        return result;
    }
}
