package utility;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Utility {
    public static List<Integer> sortAscending(List<Integer> numbers){
        Collections.sort(numbers);
        return numbers;
    }

    public static List<String> splitByComma(String input){
        return Arrays.stream(input.split(",")).toList();
    }
}
