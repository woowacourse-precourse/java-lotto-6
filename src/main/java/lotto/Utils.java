package lotto;

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
}
