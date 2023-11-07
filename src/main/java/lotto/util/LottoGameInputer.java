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

        try {
            return Integer.parseInt(input());
        } catch (NumberFormatException exception) {
            LottoGamePrinter.println(LOTTO_PURCHASE_AMOUNT_INVALID_ERROR.getMessage());
            return inputToInteger();
        }


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
