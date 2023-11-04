package lotto.utils;

import static lotto.contents.ContentErrors.INVALID_NUMBER_FORMAT;
import static lotto.contents.ContentStrings.SPLIT_COMMA;

import java.util.Arrays;
import java.util.List;

public class ParserUtil {
    //예외처리 여기서 불가능함 왜냐면 에러났다는 상황전달이안됨.

    public static int parseLottoNumber(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(SPLIT_COMMA.getValue()))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
