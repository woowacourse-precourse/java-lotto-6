package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Formatter {

    public static List<Integer> stringToIntegerList(String inputNumber) {
        List<String> stringNumber = Arrays.asList(inputNumber.split(","));
        List<Integer> numbers = new ArrayList<>();
        for (String number : stringNumber) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
