package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    public int numberParser(String input){
        return Integer.parseInt(input);
    }

    public List<Integer> correctNumberParser(String input){
        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(input.split(",")).map(i-> numbers.add(Integer.parseInt(i))).collect(Collectors.toList());

        return numbers;
    }
}
