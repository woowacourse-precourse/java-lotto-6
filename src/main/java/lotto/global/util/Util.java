package lotto.global.util;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lotto.global.exception.ErrorMessage;

public class Util {
    public static Integer parseIntOrThrowException(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
        }
    }

    public static List<Integer> parseIntToListOrThrowException(String input, String regex) {
        return Arrays.asList(input.split(regex))
                .stream()
                .map(number -> parseIntOrThrowException(number))
                .toList();
    }

    public static Double round(Double number, Integer decimal) {
        Double nSquaredTen = Math.pow(10, decimal - 1);
        return (double) Math.round(number * nSquaredTen) / nSquaredTen;
    }

    public static List<Integer> sortAsc(List<Integer> unsorted) {
        List<Integer> sortedNumbers = new ArrayList<>(unsorted);
        sortedNumbers.sort(Comparator.naturalOrder());
        return sortedNumbers;
    }
}
