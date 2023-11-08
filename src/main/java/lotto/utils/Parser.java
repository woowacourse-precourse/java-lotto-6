package lotto.utils;

import lotto.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private final Validator validator = new Validator();


    public List<Integer> parseInputWinningNumbers(String input) {
         validator.isValidIntegerNumberInList(Arrays.asList(input.split(",")));
         return Arrays.stream(stringToIntArray(input)).boxed().collect(Collectors.toList());
    }


    public int parseInputStringNumber(String input) {
        return Integer.parseInt(input);
    }

    private int[] stringToIntArray(String string) {
        return Arrays.stream(string.split(",")).mapToInt(Integer::parseInt).toArray();
    }


}
