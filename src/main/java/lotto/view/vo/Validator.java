package lotto.view.vo;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static lotto.policy.LottoNumberGeneratePolicy.MAX_NUM;
import static lotto.policy.LottoNumberGeneratePolicy.MIN_NUM;

public class Validator {

    private static final Pattern REGEX = Pattern.compile("^[0-9]*$");
    private static final String DELIMITER = ",";
    private static final int MAX_INPUT_LENGTH = 9;
    private static final int LOTTO_PRICE = 1_000;
    private static final int WINNING_NUM_SIZE = 6;

    public static void validateNull(String value) {
        if (value == null) {
            throw new IllegalArgumentException("[ERROR] 입력값이 null이 될 수 없습니다.");
        }
    }

    public static void validateIfNumeric(List<String> list) {
        list.stream()
                .filter(Validator::isNotNumeric)
                .findAny()
                .ifPresent(input -> {
                    throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다.");
                });
    }

    private static void validateIfNumeric(String value) {
        if (isNotNumeric(value)) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다.");
        }
    }

    private static boolean isNotNumeric(String value) {
        return !REGEX.matcher(value).matches();
    }

    public static void validateBonusNumber(String value, WinningNumbers winningNumbers) {
        validateNull(value);
        validateIfNumeric(value);
        validateDuplicate(Integer.parseInt(value), winningNumbers);
        validateRange(Integer.parseInt(value));
    }

    private static void validateDuplicate(int number, WinningNumbers winningNumbers) {
        if (winningNumbers.hasDuplicate(number)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private static void validateRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위를 벗어났습니다.");
        }
    }

    private static boolean isOutOfRange(int number) {
        return number < MIN_NUM || number > MAX_NUM;
    }

    public static WinningNumbers validateWinningNumbers(String value) {
        validateNull(value);
        List<String> delimiterErasedWinningNumbers = Arrays.stream(value.split(DELIMITER)).toList();
        validateIfNumeric(delimiterErasedWinningNumbers);
        List<Integer> winningNumbers = delimiterErasedWinningNumbers.stream()
                .map(Integer::parseInt)
                .toList();
        validateLength(winningNumbers);
        validateRange(winningNumbers);
        validateDuplicate(winningNumbers);
        return WinningNumbers.of(winningNumbers);
    }

    private static void validateLength(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUM_SIZE) {
            throw new IllegalArgumentException("[ERROR] 숫자는 6개만 가능합니다");
        }
    }

    private static void validateRange(List<Integer> numbers) {
        numbers.stream().filter(number -> number < MIN_NUM || number > MAX_NUM)
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException("[ERROR] 숫자는 범위를 벗어났습니다.");
                });
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private static boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != WINNING_NUM_SIZE;
    }

    public static void validateMoney(String value) {
        validateNull(value);
        validateIfNumeric(value);
        validatePrice(value);
    }

    private static void validatePrice(String value) {
        if (isHigherThanMaxInput(value)) {
            throw new IllegalArgumentException("[ERROR] 최대 금액보다 큰 값을 입력하셨습니다.");
        }
        if (isLowerThanMinimumPrice(value)) {
            throw new IllegalArgumentException("[ERROR] 최소 금액보다는 작은값을 입력하셨습니다.");
        }
        if (isNotDivisibleByMinimumPrice(value)) {
            throw new IllegalArgumentException("[ERROR] 최소 금액으로 나누어 떨어지는 값을 입력해주세요.");
        }

    }

    private static boolean isLowerThanMinimumPrice(String price) {
        return Integer.parseInt(price) < LOTTO_PRICE;
    }

    private static boolean isNotDivisibleByMinimumPrice(String price) {
        return Integer.parseInt(price) % LOTTO_PRICE != 0;
    }

    private static boolean isHigherThanMaxInput(String input) {
        return input.length() > MAX_INPUT_LENGTH;
    }

}
