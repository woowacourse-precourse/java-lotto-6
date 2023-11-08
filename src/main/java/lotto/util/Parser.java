package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<Integer> getSplitLottoNumber(String input) {
        Validator.validateParserNumbers(getSplitString(input));
        return toListInteger(getSplitString(input));
    }

    private static List<Integer> toListInteger(List<String> inputNumbers) {
        List<Integer> changeNumbers = new ArrayList<>();

        for(String input : inputNumbers) {
            changeNumbers.add(Integer.parseInt(input));
        }
        return changeNumbers;
    }

    private static List<String> getSplitString(String input) {
        String[] splitStrings = input.split(",");
        return Arrays.asList(splitStrings);
    }
}
