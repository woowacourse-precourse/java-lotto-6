package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberSplitter {
    private static final String LOTTO_NUMBERS_SPLIT_DELIM = ",";
    public static List<String> splitNumbers(String input) {
        String[] numberSplit = input.split(LOTTO_NUMBERS_SPLIT_DELIM);

        return new ArrayList<>(Arrays.asList(numberSplit));
    }
}
