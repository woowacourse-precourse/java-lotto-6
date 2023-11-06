package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public long inputAmount() {
        System.out.println(INPUT_AMOUNT);
        String input = Console.readLine();
        validateAmount(input);
        return Long.parseLong(input);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        String input = Console.readLine();
        return validateWinningNumbers(input);
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        validateBonusNumber(input);
        return Integer.parseInt(input);
    }

    public static void validateAmount(String input) {
        validateStringToNumericConversion(input);
    }

    public static List<Integer> validateWinningNumbers(String input) {
        return StringToIntConversion(input);
    }

    public static void validateBonusNumber(String input) {
        validateStringToNumericConversion(input);
    }

    private static void validateStringToNumericConversion(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 입력이 필요합니다.");
        }
    }

    private static List<Integer> StringToIntConversion(String input) {
        String[] stringWinningNumber = input.split(",");
        List<Integer> intWinningNumber = new ArrayList<>();

        for (String number : stringWinningNumber) {
            validateStringToNumericConversion(number);
            intWinningNumber.add(Integer.parseInt(number));
        }
        return intWinningNumber;
    }
}