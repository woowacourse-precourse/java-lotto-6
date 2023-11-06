package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.util.StringValidator;

public class InputUtil {
    private InputUtil() {
    }

    public static int inputMoney() {
        final String line = Console.readLine();
        StringValidator.validateOnlyNumber(line);
        return Integer.parseInt(line);
    }

    public static List<Integer> inputWinningNumbers() {
        final String line = Console.readLine();
        StringValidator.validateNotBlank(line);
        final List<String> numberStrings = Arrays.asList(line.split(","));
        return mapToInt(numberStrings);
    }

    public static int inputBonusNumber() {
        final String line = Console.readLine();
        StringValidator.validateOnlyNumber(line);
        return Integer.parseInt(line);
    }

    private static List<Integer> mapToInt(List<String> numberStrings) {
        StringValidator.validateOnlyNumber(numberStrings);
        return numberStrings.stream().map(Integer::parseInt).toList();
    }
}
