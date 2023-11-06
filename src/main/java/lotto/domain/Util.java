package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static int toNumeric(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber.strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> stringToArrayList(String inputNumbers) {
        List<Integer> numbers = Arrays.asList(inputNumbers.split(",")).stream().map(Util::toNumeric)
                .collect(Collectors.toList());
        return numbers;
    }
}
