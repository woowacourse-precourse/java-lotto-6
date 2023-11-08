package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static int stringToInteger(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> stringToIntegerList(List<String> input) {
        return input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<String> integerListToStringList(List<Integer> input) {
        return input.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    public static List<Integer> sortListAscending(List<Integer> list) {
        List<Integer> orderedList = new ArrayList<>(list);
        Collections.sort(orderedList);
        return orderedList;
    }
}
