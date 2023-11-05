package utility;

import java.util.Collections;
import java.util.List;

public class Utility {
    public static List<Integer> sortAscending(List<Integer> numbers){
        Collections.sort(numbers);
        return numbers;
    }

    public static String[] splitByComma(String input){
        return input.split(",");
    }
}
