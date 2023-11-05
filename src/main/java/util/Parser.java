package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public int parseMoneyNumber(String input) {
        return Integer.parseInt(input);
    }

    public List<String> parseLottoNumber(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }
}
