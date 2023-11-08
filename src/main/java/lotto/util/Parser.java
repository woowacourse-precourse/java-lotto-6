package lotto.util;

import java.util.List;
import java.util.stream.Stream;
import static lotto.util.ConstantMessages.INPUT_PARSER_CHAR;

public class Parser {

    public static List<String> parseStringtoList (String input) {
        return Stream.of(input.split(INPUT_PARSER_CHAR.getMessage())).toList();
    }
}
