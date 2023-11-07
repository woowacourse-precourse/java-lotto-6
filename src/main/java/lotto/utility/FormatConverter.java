package lotto.utility;

import java.util.ArrayList;
import java.util.List;

public class FormatConverter {
    public static List<Integer> toIntegerListFromStringWithComma(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (String number : input.split(",")) {
            numbers.add(TypeConverter.convertStringToInt(number));
        }

        return numbers;
    }
}
