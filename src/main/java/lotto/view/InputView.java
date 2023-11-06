package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.utils.ErrorMessage;
import lotto.utils.GameMessage;

public class InputView {
    public static int getMoneyInput() {
        System.out.println(GameMessage.ENTER_PURCHASE_AMOUNT.getMessage());
        String inputMoney = readLine();
        validateIntegerForInputMoney(inputMoney);
        return Integer.parseInt(inputMoney);
    }

    private static void validateIntegerForInputMoney(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MONEY_NOT_INTEGER_ERROR.getMessage());
        }
    }

    public static List<Integer> getWinningNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine();
        validateIntegerForWinningNumbersInput(winningNumbersInput);
        List<Integer> winningNumbersIntegerList = convertStringToIntegerList(winningNumbersInput);
        return winningNumbersIntegerList;
    }

    private static void validateIntegerForWinningNumbersInput(String input) {
        String[] parts = input.split(",");
        for (String part : parts) {
            if (!isInteger(part.trim())) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_NOT_INTEGER_ERROR.getMessage());
            }
        }
    }

    private static List<Integer> convertStringToIntegerList(String input) {
        String[] parts = input.split(",");
        List<Integer> result = new ArrayList<>();

        for (String part : parts) {
            result.add(Integer.parseInt(part));
        }
        return result;
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int getBonusNumberInput() {
        System.out.println("보너스를 입력하세요.");
        String inputBonusNumber = Console.readLine();
        validateIntegerForInputBonusNumber(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }

    private static void validateIntegerForInputBonusNumber(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_NOT_INTEGER_ERROR.getMessage());
        }
    }
}