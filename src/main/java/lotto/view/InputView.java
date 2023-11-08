package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public static String insertBuyPrice() {
        String buyPrice = Console.readLine();
        return buyPrice;
    }

    public static String insertWinningNumber() {
        String winningNumber = Console.readLine();
        return winningNumber;
    }

    public static String insertBonusNumber() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }

    public static int convertToInt(String buyPrice) {
        return Integer.parseInt(buyPrice);
    }

    public static List<Integer> convertToList(String winningNumber) {
        List<String> numbers = List.of(winningNumber.split(","));
        return convertToIntList(numbers);
    }

    private static List<Integer> convertToIntList(List<String> numbers) {
        return numbers.stream()
                .map(Integer::parseInt)
                .toList();
    }
}