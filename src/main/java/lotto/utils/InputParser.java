package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    public List<Integer> parseLottoNumbers(String input) {
        String[] numberStrings = input.split(",");
        return Arrays.stream(numberStrings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int parseLottoBonusNumber(String input) {
        return Integer.parseInt(input);
    }

}
