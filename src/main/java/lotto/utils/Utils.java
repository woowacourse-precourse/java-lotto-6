package lotto.utils;

import java.util.ArrayList;
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
        List<Integer> list = new ArrayList<>();
        List<String> strings = Utils.splitStringToList(winnerNumber);
        for (String string : strings) {
            list.add(Integer.parseInt(string));
        }
        return list;
    }
}
