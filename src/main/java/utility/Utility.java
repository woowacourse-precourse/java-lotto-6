package utility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utility {
    public static List<Integer> sortAscending(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(",")).toList();
    }
}
