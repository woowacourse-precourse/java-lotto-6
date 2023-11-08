package lotto.controller.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public int parseToInteger(String input) throws NumberFormatException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자가 아닙니다.");
        }
    }

    public List<Integer> parseLottoNumbers(String input) {
        String[] numberStrings = input.split(",");
        return Arrays.stream(numberStrings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
