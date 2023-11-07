package lotto.util.parser;

import static lotto.Constants.INTEGER_REGEX;
import static lotto.exception.ExceptionMessages.NEGATIVE_NUMBER_INPUT_MESSAGE;
import static lotto.exception.ExceptionMessages.ONLY_NUMBER_INPUT_MESSAGE;

import java.util.Arrays;
import java.util.List;

public class Parser {
    /**
     * Description: Parse String[] to List&lt;Integer&gt;
     */
    public static List<Integer> parseStringArrToIntList(String[] args) {
        return Arrays.stream(args)
                .map(Integer::parseInt)
                .toList();
    }

    /**
     * Description: Parse String to int
     */
    public static int parseStringToInt(String arg) {
        //음수도 허용
        if (!arg.matches(INTEGER_REGEX)) {
            throw new IllegalArgumentException(ONLY_NUMBER_INPUT_MESSAGE);
        }
        if (Integer.parseInt(arg) < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_INPUT_MESSAGE);
        }
        return Integer.parseInt(arg);
    }
}
