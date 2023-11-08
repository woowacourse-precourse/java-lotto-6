package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypeConverter {
    public static List<Integer> convertToIntegers(String numbers) throws NumberFormatException {
        List<String> numbersSplit = Arrays.asList(numbers.split(","));
        List<Integer> numbersConverted = new ArrayList<>();

        for (String number : numbersSplit) {
            numbersConverted.add(convertToInteger(number));
        }
        return numbersConverted;
    }

    public static int convertToInteger(String number) throws NumberFormatException {
        return Integer.parseInt(number.strip());
    }
}
