package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoParser {
    private static final String SPLIT_CHAR = ",";
    private static final String WINNING_PARSE_ERROR_MESSAGE = "입력은 번호 구분을 위해 쉼표를 포함하며, 각 번호는 정수만을 허용헙니다.";

    public static List<Integer> parseWinningInputs(String input){
        try{
            return Arrays.stream(input.split(SPLIT_CHAR))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(WINNING_PARSE_ERROR_MESSAGE);
        }
    }
}
