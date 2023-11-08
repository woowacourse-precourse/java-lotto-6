package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.message.ExceptionMessage;
import lotto.view.message.OutputMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String COMMA = ",";
    public static int inputPurchaseAmount() {
        String input = "";
        try {
            System.out.println(OutputMessage.ASK_PURCHASE_AMOUNT.getMessage());
            input = Console.readLine();
            validateInputBlank(input);
            validateInputNumber(input);
        } catch(IllegalArgumentException e) {
            System.out.println(ExceptionMessage.ERROR_MESSAGE.getMessage());
        }
        return Integer.parseInt(input);
    }


    private static void validateInputBlank(String input) {
        if (input.replaceAll(" ", "").equals("")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateInputNumber(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }
    }

    public static List inputWinnerNumbers() {
        String input = "";
        try {
            System.out.println(OutputMessage.ASK_WINNER_NUMBERS.getMessage());
            input = Console.readLine();
            validateInputBlank(input);
        } catch(IllegalArgumentException e) {
            System.out.println(ExceptionMessage.ERROR_MESSAGE_ABOUT_BLANK_INPUT.getMessage());
        }
        return convertStringToListWithDelimeter(input);
    }

    public static int inputBonusNumber() {
        String input = "";
        try {
            System.out.println(OutputMessage.ASK_BONUS_NUMBER.getMessage());
            input = Console.readLine().replaceAll(" ", "");
            validateInputBlank(input);
        } catch(IllegalArgumentException e) {
            System.out.println(ExceptionMessage.ERROR_MESSAGE_ABOUT_BLANK_INPUT.getMessage());
        }
        return Integer.parseInt(input);
    }

    private static List<Integer> convertStringToListWithDelimeter(String input) {
        return Arrays.stream(input.replaceAll(" ", "").split(COMMA)).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

}
