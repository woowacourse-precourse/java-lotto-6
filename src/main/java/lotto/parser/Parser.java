package lotto.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.CharacterUnits.COMMA;

public class Parser {

    private static final String SEPARATOR = ",";

    public static List<String> parseNumberDummy(String input) {
        return Arrays.stream(input
                        .split(SEPARATOR))
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
            throw new IllegalStateException("[ERROR] 잘못된 숫자 형식입니다.");
        }
    }

}
