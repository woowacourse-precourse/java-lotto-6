package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypeConverter {
    public static List<Integer> strToIntList(String inputNumbers) {
        List<Integer> intListNumbers = new ArrayList<>();
        String[] strArrNumbers = inputNumbers.split(",");
        for (String number : strArrNumbers) {
            intListNumbers.add(Integer.parseInt(number));
        }
        return intListNumbers;
    }
    public static int strToInt(String inputNumber) {
        return Integer.parseInt(inputNumber);
    }
}
