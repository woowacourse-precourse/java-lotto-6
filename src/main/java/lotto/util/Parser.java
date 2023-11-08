package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public List<String> getSplitLottoNumber(String input) {
        Validator.validateParserNumbers(getSplitString(input));
        return getSplitString(input);
    }

    private List<String> getSplitString(String input) {
        String[] splitStrings = input.split(",");
        return Arrays.asList(splitStrings);
    }
}
