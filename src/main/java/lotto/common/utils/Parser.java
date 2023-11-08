package lotto.common.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.constants.Symbol;

public class Parser {
    public static List<String> stringToStringList(String inputString) {
        return Arrays.stream(inputString.split(Symbol.COMMA.getSymbol()))
                .map(String::trim)
                .toList();
    }

    public static List<Integer> stringListToIntegerList(List<String> inputStringList) {
        return inputStringList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<String> integerListToStringList(List<Integer> inputIntegerList) {
        return inputIntegerList.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    public static double percentage(double total, double value) {
        return (value / total) * 100.0;
    }
}
