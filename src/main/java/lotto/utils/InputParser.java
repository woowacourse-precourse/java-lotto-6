package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class InputParser {
    public int parseToInt(String input) {
        return Integer.parseInt(input);
    }

    public List<String> splitByComma(String input) {
        return Arrays.asList(input.split(","));
    }
}
