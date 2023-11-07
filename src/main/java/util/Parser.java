package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    public int parseNumber(String input) {
        return Integer.parseInt(input);
    }

    public List<Integer> parseLottoNumberToInt(String input) {
        List<Integer> result = Stream.of((input).split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return result;
    }

    public List<String> parseLottoNumber(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }
}
