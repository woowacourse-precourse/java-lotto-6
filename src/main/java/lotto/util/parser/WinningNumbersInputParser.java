package lotto.util.parser;

import static lotto.consts.ErrorMessage.LOTTO_WRONG_INPUT_ERROR_MESSAGE;
import static lotto.consts.ErrorMessage.PARSE_INT_ERROR_MESSAGE;
import static lotto.consts.ErrorMessage.throwException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WinningNumbersInputParser extends InputParser {

    private static final String DELIMITER = ",";
    private static final Pattern PATTERN = Pattern.compile("^\\d+(,\\d+)*$");

    @Override
    public List<Integer> parse(String input) {
        input = removeSpaces(input);
        validate(input);
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
        for (String value : input) {
            try {
                result.add(parseInt(value));
            } catch (NumberFormatException e) {
                throwException(PARSE_INT_ERROR_MESSAGE.get());
            }
        }
        return result;
    }

    private int parseInt(String value) {
        return Integer.parseInt(value);
    }
}
