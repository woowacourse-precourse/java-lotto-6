package lotto.parse;
import java.util.*;
import java.util.stream.Collectors;

public class Parsing {
    private static final String STRING_COMMA = ",";
    public static int stringToInt(String inputValue){
        return Integer.parseInt(inputValue);
    }

    public static List<Integer> makeList(String inputValue){
        String [] splitString = splitByComma(inputValue);
        return stringArrayToIntegerList(splitString);
    }

    public static String[] splitByComma(String input){
        return input.split(STRING_COMMA);
    }

    public static List<Integer> stringArrayToIntegerList(String[] input){
        return Arrays.stream(input).map(s->stringToInt(s)).collect(Collectors.toList());
    }

}
