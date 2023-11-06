package utils;

import java.util.ArrayList;
import java.util.List;

public class Parse {
    public static List<Integer> parseInteger(List<String> stringArray) {
        List<Integer> IntegerArray = new ArrayList<>();
        for (String string : stringArray) {
            IntegerArray.add(Integer.parseInt(string));
        }
        return IntegerArray;
    }
}
