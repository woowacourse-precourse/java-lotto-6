package utils;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static int stringToInt(String input) {
        return Integer.parseInt(input);
    }

    public static String[] splitByDelimiter(String inputs, String delimiter) {
        return inputs.split(delimiter);
    }

    public static List<Integer> stringArrayToList(String[] inputs) {
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            numbers.add(stringToInt(input));
        }
        return numbers;
    }
}
