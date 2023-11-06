package lotto.util.converter;

import java.util.List;

public class ListConverter {
    public static List<String> convertListIntegerToString(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .toList();
    }
}
