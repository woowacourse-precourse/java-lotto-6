package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static List<String> splitStringToList(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    public static List<String> convertIntegerToString(List<Integer> input) {
        List<String> result = input.stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        return result;
    }

    public static List<Integer> convertIntegerList(String winnerNumber) {
        List<String> strings = Utils.splitStringToList(winnerNumber);
        List<Integer> list = strings.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return list;
    }
}
