package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static void readBuyAmount() {
        String input = Console.readLine();
        validateSpaceBuyAmount(input);
        validateNotIntegerBuyAmount(input);
        validateNotDividedBuyAmount(input);
    }

    public static void readWinningNumber() {
        String input = Console.readLine();
        validateSpaceWinningNumber(input);
        validateNotIntegerWinningNumber(input);
        validateIsSixNumberWinningNumber(input);
        validateDuplicatedWinningNumber(input);
    }


    public static void validateDuplicatedWinningNumber(String input) {
        String[] splits = input.split(",");
        int[] numbers = Arrays.stream(splits).mapToInt(Integer::parseInt).toArray();
        int[] distinctNumbers = Arrays.stream(numbers).distinct().toArray();
        if (numbers.length != distinctNumbers.length) {
            throw new IllegalArgumentException("[ERROR] 중복된 값이 입력되었습니다.");
        }
    }

    public static void validateNotIntegerWinningNumber(String input) {
        String[] numbers = input.split(",");
        for (int i = 0; i < numbers.length; i++) {
            try {
                Integer.parseInt(numbers[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
            }
        }

    }

    public static void validateSpaceWinningNumber(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException("[ERROR] 공백이 입력되었습니다.");
        }
    }

    public static void validateIsSixNumberWinningNumber(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리가 아닌 당첨 번호가 입력되었습니다.");
        }
    }

    public static void validateSpaceBuyAmount(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException("[ERROR] 공백이 입력되었습니다.");
        }
    }

    public static void validateNotIntegerBuyAmount(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
        }
    }

    public static void validateNotDividedBuyAmount(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위가 아닌 값이 입력되었습니다.");
        }
    }


}
