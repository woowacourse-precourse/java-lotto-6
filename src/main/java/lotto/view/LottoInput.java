package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static lotto.view.ConstantsMessage.*;

public class LottoInput {
    public String askPrice() {
        System.out.println(ASK_BUY_PRICE.getMessage());
        String input = Console.readLine();
        return input;

    }

    public List<String> prizeNumberInput() {
        printNewLine();
        System.out.println(ASK_PRIZE_NUMBER.getMessage());
        List<String> input = Arrays.asList(Console.readLine().split(","));
        return input;
    }
    private void printNewLine() {
        System.out.println();
    }
}
