package lotto.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    private Utils() {
    }

    public static List<Integer> getSortedList(List<Integer> input) {
        return input.stream()
                .sorted()
                .toList();
    }

    public static ArrayList<String> splitWithComma(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public static ArrayList<Integer> stringToInteger(ArrayList<String> input) {
        return input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static double calculatePercentage(int income, int inputMoney) {
        return (double) income * 100 / inputMoney;
    }
}
