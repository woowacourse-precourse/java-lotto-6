package lotto.util;

import static java.util.Collections.*;
import static lotto.util.ConstantMessages.INPUT_PARSER_CHAR;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Parser {
    public static List<String> parseStringtoList (String input) {
        return Stream.of(input.split(INPUT_PARSER_CHAR.getMessage())).toList();
    }
}
