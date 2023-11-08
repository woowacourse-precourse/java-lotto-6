package lotto.view;

import static lotto.view.ErrorMessage.printInputFormatError;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int inputMoney() {
        System.out.println(INPUT_MONEY);
        return validate(Console.readLine());
    }

    public static List<Integer> inputWinningNumbers() {
        try {
            System.out.println(INPUT_WINNING_NUMBERS);
            String[] input = Console.readLine().split(",");
            return Arrays.stream(input)
                    .map(number -> Integer.parseInt(number.trim()))
                    .toList();
        } catch(NumberFormatException e) {
            printInputFormatError();
            throw new IllegalArgumentException();
        }
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return validate(Console.readLine());
    }

    private static int validate(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            printInputFormatError();
            throw new IllegalArgumentException();
        }
    }
}
