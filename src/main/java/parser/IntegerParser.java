package parser;

import java.util.ArrayList;
import java.util.List;
public class IntegerParser {
    public static List<Integer> parseNumbers(String input) {

        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numberString :
                numberStrings) {
            numbers.add(Integer.parseInt(numberString));
        }
        return numbers;
    }
}
