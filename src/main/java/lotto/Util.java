package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public List<String> stringToList(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }

    public List<Integer> stringListToIntegerList(List<String> strList) {
        return strList.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public void sortNaturalOrder(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }
}
