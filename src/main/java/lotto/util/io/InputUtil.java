package lotto.util.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import lotto.config.GameConfig;
import lotto.exception.InputException;
import lotto.exception.LottoGameException;

public class InputUtil {

    private static final String SPLIT_REGEX = "\\s*" + GameConfig.LOTTO_NUMBER_INPUT_DELIMITER + "\\s*";

    private InputUtil() {
    }

    public static int readInt() {
        return parseToInteger(readLine());
    }

    private static int parseToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoGameException(InputException.INVALID_INTEGER);
        }
    }

    public static List<Integer> readIntegerList() {
        String input = readLine();
        validateDelimiter(input);
        return stringToIntegerList(input);
    }

    private static List<Integer> stringToIntegerList(String input) {
        try {
            return Stream.of(input.split(SPLIT_REGEX))
                    .filter(InputUtil::validateHasInput)
                    .map(Integer::valueOf)
                    .toList();
        } catch (NumberFormatException e) {
            throw new LottoGameException(InputException.INVALID_INTEGER);
        }
    }

    private static void validateDelimiter(String input) {
        if (!input.contains(GameConfig.LOTTO_NUMBER_INPUT_DELIMITER)) {
            throw new LottoGameException(InputException.INVALID_DELIMITER);
        }
    }

    private static String readLine() {
        String input = Console.readLine().trim();
        validateHasInput(input);
        return input;
    }

    private static boolean validateHasInput(String input) {
        if (input.isBlank()) {
            throw new LottoGameException(InputException.INVALID_INPUT);
        }
        return true;
    }
}
