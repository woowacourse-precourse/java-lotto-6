package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    //순수하게 입력 값을 파싱
    public static List<String> parseInput(String input) {
        return Arrays.stream(input.split(",", -1))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}