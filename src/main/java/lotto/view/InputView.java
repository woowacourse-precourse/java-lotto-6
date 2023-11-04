package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static final String PRICE_NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 입력값이 숫자가 아닙니다.";

    public static int getPurchaseLottoPrice() {
        String cost = Console.readLine();
        return costConvertToInt(cost);
    }

    private static int costConvertToInt(String cost) {
        try {
            return Integer.parseInt(cost);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PRICE_NOT_INTEGER_ERROR_MESSAGE);
        }
    }

    public static List<Integer> getUserLottoNumber() {
        String input = Console.readLine();
        String[] numbers = getSplit(input);
        return mapToInteger(numbers);
    }

    private static String[] getSplit(String input) {
        return input.split(",");
    }

    private static List<Integer> mapToInteger(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
