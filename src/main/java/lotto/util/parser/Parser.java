package lotto.util.parser;

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
}
