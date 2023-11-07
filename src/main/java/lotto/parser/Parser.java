package lotto.parser;

import java.util.List;
import java.util.stream.*;
import java.util.Arrays;

public class Parser {
    public static String[] splitString(String winNumber) {
        return winNumber.split(",");
    }

    public static int[] parseIntArray(String winNumber) {
        return Stream.of(splitString(winNumber)).mapToInt(Integer::parseInt).toArray();
    }

    public static List<Integer> parseIntList(int[] winNumbers) {
        return Arrays.stream(winNumbers).boxed().collect(Collectors.toList());
    }

    public static double getRateOfReturn(int earnMoney, int parseMoney) {
        double parseEarnMoney = (double) earnMoney;
        double rateOfReturn = parseEarnMoney / parseMoney * 100;
        return rateOfReturn;
    }
}
