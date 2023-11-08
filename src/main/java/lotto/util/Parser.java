package lotto.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    public static long stringToLong(String str) throws IllegalArgumentException{
        try {
            return Long.parseLong(str);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
    public static int stringToInt(String str) throws IllegalArgumentException{
        try{
            return Integer.parseInt(str);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();

        }
    }

    public static List<Integer> stringToList(String str) throws IllegalArgumentException {
        try {
            return Stream.of(str.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
