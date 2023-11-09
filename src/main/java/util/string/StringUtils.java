package util.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    private StringUtils() {
    }

    public static int parseStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> parseLottoNumber(String input) {
        List<String> strings = new ArrayList<>(Arrays.asList(input.split(",")));
        return strings.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
