package lotto.utils;

import lotto.validation.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private final Validator validator = new Validator();

    //추후에 stream으로 변경 가능
    public List<Integer> parseInputWinningNumbers(String input) {
         validator.isValidIntegerNumberInList(Arrays.asList(input.split(",")));
         return Arrays.stream(stringToIntArray(input)).boxed().collect(Collectors.toList());
    }

    //일단 만들어놨는데 아마 보너스 숫자는 기존 array에 추가하는 형식
    public int parseInputStringNumber(String input) {
        return Integer.parseInt(input);
    }

    private int[] stringToIntArray(String string) {
        return Arrays.stream(string.split(",")).mapToInt(Integer::parseInt).toArray();
    }


}
