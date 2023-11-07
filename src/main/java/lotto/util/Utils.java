package lotto.util;

import lotto.verification.Validation;

import java.util.*;
import java.util.stream.Collectors;

public class Utils {

    private static final String COMMAS = ",";

    public static long rangeInputMoney(long money) {
        Validation.verifyRangeInputMoney(money);
        return money;
    }

    public static long stringToLong(String string) {
        Validation.verifyEmptyInputMoney(string);
        Validation.verifyStringToLong(string);
        return Long.parseLong(string);
    }

    public static List<Integer> sortAscendingRandomLottoList(List<Integer> list) {
        List<Integer> orderedList = new ArrayList<>(list);
        Collections.sort(orderedList);
        return orderedList;
    }

    public static List<Integer> convertToLottoIntegerList(String userInput) {
        Validation.verifyIntegerWinningLottoNumber(userInput);
        Validation.verifyRangeWinningLottoNumber(userInput);
        return Arrays.stream(userInput.split(COMMAS))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int stringToInteger(String string) {
        Validation.verifyStringToInteger(string);
        return Integer.parseInt(string);

    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }

    public static String calculateReturn(long totalReturn, long money) {
        double total = (double) totalReturn / (double) money;
        double roundedTotal = Math.round(total * 10000.0) / 100.0; // 소수점 둘째 자리에서 반올림
        String result = String.format("총 수익률은 %.1f%%입니다.", roundedTotal);
        return result;
    }

    public static StringJoiner convertListToFormattedString(List<Integer> lotto) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (Integer number : lotto) {
            joiner.add(number.toString());
        }
        return joiner;
    }
}
