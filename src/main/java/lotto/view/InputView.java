package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constraints.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String DELIMITER = ",";

    public static int readPayMoney() {
        System.out.println(ViewMessage.INPUT_MONEY.getMessage());
        try {
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.INVALID_INPUT.getMessage());
            return readPayMoney();
        }
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println(ViewMessage.INPUT_WINNING_NUMBERS.getMessage());
        try {
            String input = Console.readLine();
            System.out.println();
            return Arrays.stream(input.split(DELIMITER)).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.INVALID_INPUT.getMessage());
            return readWinningNumbers();
        }
    }

    public static int readBonusNumber() {
        System.out.println(ViewMessage.INPUT_BONUS_NUMBER.getMessage());
        try {
            String input = Console.readLine();
            System.out.println();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.INVALID_INPUT.getMessage());
            return readBonusNumber();
        }
    }
}
