package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private static final String COMMA = ",";

    public static int parseInt(String input) throws IllegalArgumentException{
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> parseIntList(String input) throws IllegalArgumentException{
        try{
            return Arrays.stream(input.split(COMMA))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException();
        }
    }
}
