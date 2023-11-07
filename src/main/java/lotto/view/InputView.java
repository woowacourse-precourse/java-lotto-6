package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.ErrorMessage;

public class InputView {

    public static int getPurchaseLottoPrice() {
        String cost = Console.readLine();
        return convertToInt(cost);
    }

    public static List<Integer> getUserLottoNumber() {
        String input = Console.readLine();
        String[] numbers = getSplit(input);
        if (numbers.length != 6){
            throw new IllegalArgumentException(
                    ErrorMessage.INPUT_NUMBERS_SIZE_IS_NOT_CORRECT_MESSAGE);
        }
        return mapToInteger(numbers);
    }

    public static int getUserBonusNumber() {
        String input = Console.readLine();
        return convertToInt(input);
    }

    private static int convertToInt(String cost) {
        if (!cost.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_NOT_INTEGER_ERROR_MESSAGE);
        }
        return Integer.parseInt(cost);
    }

    private static String[] getSplit(String input) {
        if (hasNotCommand(input)){
            throw new IllegalArgumentException(ErrorMessage.INPUT_HAS_NOT_COMMAND_MESSAGE);
        }
        return input.split(",");
    }

    private static boolean hasNotCommand(String input) {
        return !input.contains(",");
    }

    private static List<Integer> mapToInteger(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
