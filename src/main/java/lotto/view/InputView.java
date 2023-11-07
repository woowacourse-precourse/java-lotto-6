package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private final static String RANGE_ERROR_MESSAGE = "[ERROR] 범위를 벗어난 값이 입력되었습니다.";
    private final static String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 값이 입력되었습니다.";
    private final static String NONE_INTEGER_ERROR_MESSAGE = "[ERROR] 숫자가 아닌 값이 입력되었습니다.";
    private final static String SPACE_ERROR_MESSAGE = "[ERROR] 공백이 입력되었습니다.";
    private final static String NONE_SIX_NUMBER_ERROR_MESSAGE = "[ERROR] 6자리가 아닌 당첨 번호가 입력되었습니다.";
    private final static String NONE_THOUSAND_ERROR_MESSAGE = "[ERROR] 1000원 단위가 아닌 값이 입력되었습니다.";
    private final static int START_NUMBER = 1;
    private final static int END_NUMBER = 45;
    private final static int VALID_LENGTH = 6;
    private final static int MAKE_PERCENTAGE = 1000;
    private final static int REMAIN_ZERO = 0;
    private static String winningInput;


    public static String readBuyAmount() {
        String input = Console.readLine();
        validateSpaceBuyAmount(input);
        validateNotIntegerBuyAmount(input);
        validateNotDividedBuyAmount(input);
        return input;
    }

    public static String readWinningNumber() {
        String input = Console.readLine();
        validateSpaceWinningNumber(input);
        validateNotIntegerWinningNumber(input);
        validateIsSixNumberWinningNumber(input);
        validateDuplicatedWinningNumber(input);
        validateRangeWinningNumber(input);
        winningInput = input;
        return input;
    }

    public static String readBonusNumber() {
        String input = Console.readLine();
        validateSpaceBonusNumber(input);
        validateNotIntegerBonusNumber(input);
        validateRangeBonusNumber(input);
        validateDuplcateBonusNumber(input, winningInput);
        return input;
    }

    private static void validateDuplcateBonusNumber(String input, String winningInput) {
        List<String> winningNumbers = List.of(winningInput.split(","));
        if (winningNumbers.contains(input)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private static void validateSpaceBonusNumber(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(SPACE_ERROR_MESSAGE);
        }
    }

    public static void validateRangeBonusNumber(String input) {
        if (Integer.parseInt(input) < START_NUMBER || Integer.parseInt(input) > END_NUMBER) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    public static void validateNotIntegerBonusNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NONE_INTEGER_ERROR_MESSAGE);
        }
    }

    public static void validateRangeWinningNumber(String input) {
        String[] strs = input.split(",");
        for (String str : strs) {
            if (Integer.parseInt(str) < START_NUMBER || Integer.parseInt(str) > END_NUMBER) {
                throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
            }
        }
    }


    public static void validateDuplicatedWinningNumber(String input) {
        String[] splits = input.split(",");
        int[] numbers = Arrays.stream(splits).mapToInt(Integer::parseInt).toArray();
        int[] distinctNumbers = Arrays.stream(numbers).distinct().toArray();
        if (numbers.length != distinctNumbers.length) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validateNotIntegerWinningNumber(String input) {
        String[] numbers = input.split(",");
        for (int i = 0; i < numbers.length; i++) {
            try {
                Integer.parseInt(numbers[i]);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(NONE_INTEGER_ERROR_MESSAGE);
            }
        }

    }

    public static void validateSpaceWinningNumber(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(SPACE_ERROR_MESSAGE);
        }
    }

    public static void validateIsSixNumberWinningNumber(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != VALID_LENGTH) {
            throw new IllegalArgumentException(NONE_SIX_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void validateSpaceBuyAmount(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(SPACE_ERROR_MESSAGE);
        }
    }

    public static void validateNotIntegerBuyAmount(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NONE_INTEGER_ERROR_MESSAGE);
        }
    }

    public static void validateNotDividedBuyAmount(String input) {
        if (Integer.parseInt(input) % MAKE_PERCENTAGE != REMAIN_ZERO) {
            throw new IllegalArgumentException(NONE_THOUSAND_ERROR_MESSAGE);
        }
    }


}
