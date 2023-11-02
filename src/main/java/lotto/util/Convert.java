package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convert {

    public static Integer stringToInteger(String inputValue) {
        return Integer.parseInt(inputValue);
    }

    public static List<Integer> stringToIntegerList(String inputValue) {
        return Arrays.stream(inputValue.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
