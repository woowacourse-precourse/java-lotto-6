package lotto.util;

import java.util.List;

public class Convertor {
    public static List<Integer> convertListStringToInteger (List<String> input) {
        return input.stream().map(Integer::parseInt).toList();
    }
}
