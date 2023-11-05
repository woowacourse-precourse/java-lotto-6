package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Splitter {
    public static List<String> splitByComma(String input){
        return Arrays.stream(input.split(","))
                .toList();
    }

}
