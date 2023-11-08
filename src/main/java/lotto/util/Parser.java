package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static int convertInt (String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> convertStringWithNumbers (String input){
        List<Integer> numbers = new ArrayList<>();
        String[] numberStrings = input.split(",");

        for (String numberString : numberStrings) {
            numbers.add(convertInt(numberString));
        }

        return numbers;
    }

}
