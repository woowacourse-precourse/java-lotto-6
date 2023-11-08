package lotto.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    private static final String SPLIT_POINT = ",";

    public static List<Integer> stringToList(String input){
        List<String> numbers = Arrays.asList(input.split(SPLIT_POINT));
        try{
            return numbers.stream().map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER);
        }
    }

    public static int stringToInteger(String input){
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER);
        }
    }
}
