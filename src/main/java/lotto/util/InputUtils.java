package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.util.InputConvertUtils.lottoNumbersToIntegerList;
import static lotto.util.InputValidationUtils.validateHasInput;
import static lotto.util.InputValidationUtils.validateIsIntFormat;

public class InputUtils {

    public static int readInt() {
        String input = Console.readLine();

        validateHasInput(input);
        validateIsIntFormat(input);

        return Integer.parseInt(input);
    }

    public static List<Integer> readLottoNumbers() {
        return lottoNumbersToIntegerList(readLine());
    }

    private static String readLine() {
        String input = Console.readLine();
        validateHasInput(input);
        return input;
    }
}
