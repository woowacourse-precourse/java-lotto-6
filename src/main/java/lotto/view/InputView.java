package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputView {
    private static final String INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static List<Integer> intWinningNumber = new ArrayList<>();
    public static long inputAmount() {
        System.out.println(INPUT_AMOUNT);
        String input = Console.readLine();
        try {
            return validateAmount(input);
        } catch (IllegalArgumentException e) {
            return inputAmount();
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

    public static long validateAmount(String input) {
        return validateStringToNumericConversion(input);
    }

    public static List<Integer> validateWinningNumbers(String input) {
        return StringToIntConversion(input);
    }

    public static void validateBonusNumber(String input) {
        validateStringToNumericConversion(input);
    }

    private static long validateStringToNumericConversion(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자 입력이 필요합니다.");
            throw new IllegalArgumentException("[ERROR] 숫자 입력이 필요합니다.");
        }
    }

    private static List<Integer> StringToIntConversion(String input) {
        String[] stringWinningNumber = input.split(",");
        intWinningNumber.clear();
        for (String number : stringWinningNumber) {
            validateStringToNumericConversion(number.trim());
            intWinningNumber.add(Integer.parseInt(number));
        }
        Collections.sort(intWinningNumber);
        return intWinningNumber;
    }
}