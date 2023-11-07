package lotto.console.game.lotto;

import java.util.Arrays;
import java.util.List;

public class LottoGameInputConverter {

    public static int convertMoney(String moneyInput) {
        return parseInt(moneyInput);
    }

    public static List<Integer> convertNumbers(String numbersInput) {
        String[] numberStrings = splitStringByComma(numbersInput);

        return Arrays.stream(numberStrings)
                .map(Integer::parseInt)
                .toList();
    }

    public static int convertNumber(String numberInput) {
        return parseInt(numberInput);
    }

    public static int parseInt(String string) {
        return Integer.parseInt(string);
    }

    public static String[] splitStringByComma(String string) {
        return string.split(",");
    }

}
