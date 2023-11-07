package lotto.util;

import lotto.verification.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {


    private static final String COMMAS = ",";

    public static long stringToLong(String string) {
        Validation.verifyStringToLong(string);
        return Long.parseLong(string);
    }

    public static int stringToInteger(String string) {
        Validation.verifyStringToInteger(string);
        return Integer.parseInt(string);

    }

    public static long rangeInputMoney(long money) {
        Validation.verifyRangeInputMoney(money);
        return money;
    }

    public static int rangeInputBonusNumber(int bonusNumber) {
        Validation.verifyRangeInputBonusNumber(bonusNumber);
        return bonusNumber;
    }

    public static List<Integer> convertToLottoIntegerList(String userInput) {
        Validation.verifyIntegerWinningLottoNumber(userInput);
        Validation.verifyRangeWinningLottoNumber(userInput);
        return Arrays.stream(userInput.split(COMMAS))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }

    public static List<Integer> sortAscendingRandomLottoList(List<Integer> list) {
        List<Integer> orderedList = new ArrayList<>(list);
        Collections.sort(orderedList);
        return orderedList;
    }

}
