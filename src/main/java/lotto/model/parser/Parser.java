package lotto.model.parser;

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

public class Parser {
    private Parser() {
    }

    public static List<Integer> parseInputToWinningNumbers(String input) {
        validateEmpty(input);
        validateFormat(input);

        List<String> inputs = new ArrayList<>(Arrays.asList(input.split(NUMBER_SPLIT_FORMAT)));
        List<Integer> inputNumbers = inputs.stream().map(String::trim).map(Integer::parseInt).toList();

        validateLength(inputNumbers);
        validateNumberRange(inputNumbers);
        validateUniqueValue(inputNumbers);
        return inputNumbers;
    }

    public static int parseInputToBonusNumber(List<Integer> winningNumbers, String input) {
        validateEmpty(input);
        validateNumber(input);

        int parsInt = Integer.parseInt(input);

        validateNumberRange(parsInt);
        validateUniqueValue(winningNumbers, parsInt);
        return parsInt;
    }

    public static int parseInputToPurchasePrice(String input) {
        validateEmpty(input);
        validateNumber(input);

        int parsInt = Integer.parseInt(input);

        validatePrice(parsInt);
        return parsInt;
    }
}
