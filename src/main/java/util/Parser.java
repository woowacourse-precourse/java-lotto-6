package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public int parseNumber(String input) {
        return Integer.parseInt(input);
    }

    public List<Integer> parseLottoNumberToInt(String input) {
        return new ArrayList<>(Arrays.asList(Integer.parseInt(Arrays.toString(input.split(",")))));
    }
}
