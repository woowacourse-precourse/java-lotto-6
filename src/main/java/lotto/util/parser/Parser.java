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
     *
     * @throws IllegalArgumentException
     */
    public static int parseStringToInt(String arg) {
        if (!arg.matches(INTEGER_REGEX)) {
            throw new IllegalArgumentException(ONLY_NUMBER_INPUT_MESSAGE);
        }
        if (Integer.parseInt(arg) < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_INPUT_MESSAGE);
        }
        return Integer.parseInt(arg);
    }

    /**
     * Description: Parse comma separated String to List&lt;Integer&gt;<br> ex) "1,2,3,4,5,6" -&gt; [1, 2, 3, 4, 5, 6]
     */
    public static List<Integer> parseCommaStringToIntList(String arg) {
        return parseStringArrToIntList(Arrays.stream(arg.split(",")).toArray(String[]::new));
    }
}
