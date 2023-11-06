package lotto.utils;

import static lotto.utils.constants.LottoConstants.NUMBER_SPLIT_FORMAT;
import static lotto.utils.validator.Validator.validBlank;
import static lotto.utils.validator.Validator.validFormat;
import static lotto.utils.validator.Validator.validIsNumber;
import static lotto.utils.validator.Validator.validLength;
import static lotto.utils.validator.Validator.validRange;
import static lotto.utils.validator.Validator.validUniqueValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoNumberParser {
    public static List<Integer> parseListStringToListInteger(String input) {
        validBlank(input);
        validFormat(input);

        List<String> inputs = new ArrayList<>(Arrays.asList(input.split(NUMBER_SPLIT_FORMAT)));
        List<Integer> inputNumbers = inputs.stream().map(String::trim).map(Integer::parseInt).toList();

        validUniqueValue(inputNumbers);
        validLength(inputNumbers);
        validRange(inputNumbers);
        return inputNumbers;
    }

    public static int parseStringToInt(String input) {
        validBlank(input);
        validIsNumber(input);
        return Integer.parseInt(input);
    }
}
