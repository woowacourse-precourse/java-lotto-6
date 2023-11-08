package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int getPurchaseAmountFromUser() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> getWinningNumbersFromUser() {
        return changeStringToIntegerList(Console.readLine());
    }

    private List<Integer> changeStringToIntegerList(String input) {
        List<Integer> result = Arrays.stream(input.split(ViewMessages.SPLIT.getMessage()))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return result;

    }

    public int getBonusNumberFromUser() {
        return Integer.parseInt(Console.readLine());
    }
}
