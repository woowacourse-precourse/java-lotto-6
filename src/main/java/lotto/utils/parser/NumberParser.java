package lotto.utils.parser;

import static lotto.utils.constants.LottoConstants.NUMBER_SPLIT_FORMAT;
import static lotto.utils.validator.Validator.validateEmpty;
import static lotto.utils.validator.Validator.validateFormat;
import static lotto.utils.validator.Validator.validateLength;
import static lotto.utils.validator.Validator.validateNumber;
import static lotto.utils.validator.Validator.validateNumberRange;
import static lotto.utils.validator.Validator.validatePrice;
import static lotto.utils.validator.Validator.validateUniqueValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberParser {
    private NumberParser() {
    }

    public static List<Integer> parseListStringToListInteger(String input) {
        validateEmpty(input);
        validateFormat(input);

        List<String> inputs = new ArrayList<>(Arrays.asList(input.split(NUMBER_SPLIT_FORMAT)));
        List<Integer> inputNumbers = inputs.stream().map(String::trim).map(Integer::parseInt).toList();

        validateLength(inputNumbers);
        validateNumberRange(inputNumbers);
        validateUniqueValue(inputNumbers);
        return inputNumbers;
    }

    public static int parseStringToIntNumber(String input) {
        validateEmpty(input);
        validateNumber(input);

        int parsInt = Integer.parseInt(input);

        validateNumberRange(parsInt);
        return parsInt;
    }

    public static int parseStringToIntPrice(String input) {
        validateEmpty(input);
        validateNumber(input);

        int parsInt = Integer.parseInt(input);

        validatePrice(parsInt);
        return parsInt;
    }
}
