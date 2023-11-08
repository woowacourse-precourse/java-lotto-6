package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputView {

    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static List<Integer> winningNumber = new ArrayList<>();

    public static long inputMoney() {
        System.out.println(INPUT_MONEY);
        String input = Console.readLine();
        try {
            return validateMoney(input);
        } catch (IllegalArgumentException e) {
            return inputMoney();
        }
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        String input = Console.readLine();
        return validateWinningNumbers(input);
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        validateBonusNumber(input);
        return Integer.parseInt(input);
    }

    public static long validateMoney(String input) {
        return validateString(input);
    }

    public static List<Integer> validateWinningNumbers(String input) {
        return StringToIntConversion(input);
    }

    public static void validateBonusNumber(String input) {
        validateString(input);
    }

    private static long validateString(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자 입력이 필요합니다.");
            throw new IllegalArgumentException("[ERROR] 숫자 입력이 필요합니다.");
        }
    }

    private static void validateNumberBlank(String number) {
        if (number.contains(" ")) {
            System.out.println("[ERROR] 공백 없이 입력이 필요합니다.");
            throw new IllegalArgumentException("[ERROR] 공백 없이 입력이 필요합니다.");
        }
    }

    private static List<Integer> StringToIntConversion(String input) {
        String[] stringWinningNumber = input.split(",");
        winningNumber.clear();
        for (String number : stringWinningNumber) {
            validateNumberBlank(number);
            validateString(number);
            winningNumber.add(Integer.parseInt(number));
        }
        Collections.sort(winningNumber);
        return winningNumber;
    }
}
