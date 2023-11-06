package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.WinningNumberValidator;

public class InputView {

    public int insertBuyPrice() {
        String buyPrice = Console.readLine();
        return convertToInt(buyPrice);
    }

    public static int convertToInt(String buyPrice) {
        return Integer.parseInt(buyPrice);
    }

    public List<Integer> insertWinningNumber() {
        String winningNumber = Console.readLine();
        new WinningNumberValidator(winningNumber);
        return convertToList(winningNumber);
    }

    private List<Integer> convertToList(String winningNumber) {
        List<String> numbers = List.of(winningNumber.split(","));
        return convertToIntList(numbers);
    }

    private List<Integer> convertToIntList(List<String> numbers) {
        return numbers.stream()
                .map(Integer::parseInt)
                .toList();
    }
}