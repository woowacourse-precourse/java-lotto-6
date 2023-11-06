package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import lotto.util.validator.ListValidator;
import lotto.util.validator.MoneyValidator;
import lotto.util.validator.StringValidator;

public class InputUtil {
    private InputUtil() {
    }

    public static long inputMoney() {
        return inputUntilValidated(() -> {
            System.out.println("구입금액을 입력하세요.");
            final String line = Console.readLine();
            StringValidator.validateOnlyNumber(line);
            long money = Long.parseLong(line);
            MoneyValidator.validateMinimumMoney(money);
            return Long.parseLong(line);
        });
    }

    public static List<Integer> inputWinningNumbers() {
        return inputUntilValidated(() -> {
            System.out.println("당첨 번호를 입력해주세요.");
            final String line = Console.readLine();
            StringValidator.validateNotBlank(line);
            final List<String> numberStrings = Arrays.asList(line.split(","));
            final List<Integer> numbers = mapToInt(numberStrings);
            ListValidator.validateNumbersSize(numbers);
            ListValidator.validateUniqueNumbers(numbers);
            return numbers;
        });
    }

    public static int inputBonusNumber(List<Integer> numbers) {
        return inputUntilValidated(() -> {
            System.out.println("보너스 번호를 입력해 주세요.");
            final String line = Console.readLine();
            StringValidator.validateOnlyNumber(line);
            final int bonusNumber = Integer.parseInt(line);
            ListValidator.validateNotContains(numbers, bonusNumber);
            return bonusNumber;
        });
    }

    private static List<Integer> mapToInt(List<String> numberStrings) {
        StringValidator.validateOnlyNumber(numberStrings);
        return numberStrings.stream().map(Integer::parseInt).toList();
    }

    private static <T> T inputUntilValidated(Supplier<T> inputMethod) {
        final String message = "[ERROR] %s";
        while (true) {
            try {
                return inputMethod.get();
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(String.format(message, e.getMessage()));
            }
        }
    }
}
