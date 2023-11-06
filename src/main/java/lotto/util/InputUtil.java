package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputUtil {
    public static int inputMoney() {
        String input = Console.readLine();
        int money = stringToInt(input);
        return money;
    }

    public static List<Integer> inputWinningNumber() {
        try {
            String input = Console.readLine();
            List<Integer> numbers = splitToInt(input);
            validateWinningNumberCount(numbers);
            validateWinningNumberRange(numbers);
            validateDuplicationWinningNumber(numbers);
            return numbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }
    }

    public static void inputBonusNumber() {
        String input = Console.readLine();
    }

    public static List<Integer> splitToInt(String input) {
        List<String> split = List.of(input.split(","));
        return split.stream()
                .map(InputUtil::stringToInt)
                .toList();
    }

    private static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

//    public static void validateZeroOverMoney(int money) {
//        if (money <= MIN_AMOUNT) {
//            throw new IllegalArgumentException("[ERROR] 금액을 0원 이상 입력해주세요.");
//        }
//    }
//
//    public static void validateOneThousandUnitsMoney(int money) {
//        if (money % AMOUNT_UNIT != 0) {
//            throw new IllegalArgumentException("[ERROR] 금액을 1000원 단위로 입력해주세요.");
//        }
//    }

    public static void validateDuplicationWinningNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 숫자를 입력해주세요.");
        }
    }

    public static void validateWinningNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }
    }

    public static void validateWinningNumberRange(List<Integer> numbers) {
        numbers.stream().filter(number -> number < 1 || number > 45).forEach(number -> {
            throw new IllegalArgumentException("1부터 45 사이의 값만 입력해주세요.");
        });
    }
}
