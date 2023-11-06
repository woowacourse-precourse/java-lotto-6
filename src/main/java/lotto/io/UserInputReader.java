package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.exception.NonPureNumberException;

public class UserInputReader {

    private static final String pureNumberPattern = "^\\d+$";
    private static final String seperator = ",";

    public static Integer readPureNumber() throws IllegalArgumentException {
        String rawInput = Console.readLine().trim();
        validatePureNumber(rawInput);
        return Integer.parseInt(rawInput);
    }

    public static List<Integer> readMultiplePureNumbers() throws IllegalArgumentException {
        String rawInput = Console.readLine().trim();
        validateMultipleNumbers(rawInput);
        return Arrays.stream(rawInput.split(seperator))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void close() {
        Console.close();
    }

    public static void validatePureNumber(String rawInput) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(pureNumberPattern);
        Matcher matcher = pattern.matcher(rawInput);
        if (!matcher.matches()) {
            throw new NonPureNumberException();
        }
    }

    public static void validateMultipleNumbers(String rawInput) throws IllegalArgumentException {
        for (String token : rawInput.split(seperator)) {
            validatePureNumber(token.trim());
        }
    }
}
