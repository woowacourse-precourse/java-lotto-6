package lotto.util;

import lotto.verification.Validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {


    private static final String COMMAS = ",";

    public static long stringToLong(String string) {
        Validation.verifyStringToLong(string);
        return Long.parseLong(string);
    }

    public static long rangeInputMoney(long money){
        Validation.verifyRangeInputMoney(money);
        return money;
    }

    public static List<Integer> convertToLottoIntegerList(String userInput) {
        Validation.verifyRangeWinningLottoNumber(userInput);
        return Arrays.stream(userInput.split(COMMAS))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
