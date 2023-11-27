package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.ConstantsMessage.*;

public class LottoInput {
    public String askPrice() {
        System.out.println(ASK_BUY_PRICE.getMessage());
        String input = Console.readLine();
        return input;

    }

    public List<Integer> prizeNumberInput() {
        printNewLine();
        System.out.println(ASK_PRIZE_NUMBER.getMessage());
        return changeInt(Arrays.asList(Console.readLine().split(",")));
    }

    private List<Integer> changeInt(List<String> prizeNumbers) {
        return   prizeNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void printNewLine() {
        System.out.println();
    }
}
