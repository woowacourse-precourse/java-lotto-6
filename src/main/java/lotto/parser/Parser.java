package lotto.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.exception.InputViewExceptionMessage.WRONG_NUMBER_FORMAT;
import static lotto.util.CharacterUnits.COMMA;
import static lotto.util.CharacterUnits.SEPARATOR;

public class Parser {

    public static List<String> parseNumberDummy(String input) {
        return Arrays.stream(input
                        .split(SEPARATOR.getUnit()))
                        .toList();
    }

    public static List<Integer> parseNumbers(List<String> numberDummy) {
        return numberDummy.stream()
                .map(Parser::parseInt)
                .collect(Collectors.toList());
    }


    public static Integer parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalStateException(WRONG_NUMBER_FORMAT.getMessage());
        }
    }

}
