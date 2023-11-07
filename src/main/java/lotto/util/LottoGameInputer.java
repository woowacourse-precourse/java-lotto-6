package lotto.util;


import static lotto.common.ErrorMessage.LOTTO_PURCHASE_AMOUNT_INVALID_ERROR;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGameInputer {
    public static String input() {
        return Console.readLine();
    }

    public static Integer inputToInteger() {
        Integer result = null;
        while (result == null) {
            try {
                result = Integer.parseInt(input());
            } catch (NumberFormatException exception) {
                LottoGamePrinter.println(LOTTO_PURCHASE_AMOUNT_INVALID_ERROR.getMessage());
            }
        }

        return result;
    }

    public static List<Integer> convertCommaSeparatedValuesToList() {
        return Arrays.stream(input().split(","))
                .filter(value -> !value.isEmpty())
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
