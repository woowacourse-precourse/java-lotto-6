package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public List<Integer> parseWinningNumber(String input){
        return parseStringToIntegerList(parseSplitByComma(input));
    }
    public List<String> parseSplitByComma(String input){
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }
    public List<Integer> parseStringToIntegerList(List<String> input){
        return input.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
    public int parseInteger(String input){
        return Integer.parseInt(input);
    }
}
