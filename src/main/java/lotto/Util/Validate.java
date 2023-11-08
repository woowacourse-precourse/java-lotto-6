package lotto.Util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_BUY_MIN = 1000;
    private static final String NOT_NUMBER_SIZE = "[ERROR] 당첨 번호는 6개 입력 가능합니다.";
    private static final String NOT_NUMBER_DUPLICATE = "[ERROR] 중복된 숫자를 입력하셨습니다.";
    private static final String NOT_NUMBER_RANGE = "[ERROR] 숫자는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이의 숫자여야 합니다.";
    private static final String NOT_NUMBER = "[ERROR] 금액은 숫자만 등록 가능합니다.";
    private static final String NOT_NATURAL_NUMBER = "[ERROR] 금액은 0보다 커야합니다.";
    private static final String NOT_DIVISIBLE_NUMBER = "[ERROR] 금액은 " + LOTTO_BUY_MIN + "단위여야 합니다.";
    private static final String INPUT_TYPE_ERROR = "[ERROR] 숫자만 입력해 주세요.";

    public static void validateAmount(int amount) {
        validateNatural(amount);
        validateDivisible(amount);
    }

    public static void validateBonusNum(List<Integer> numbers, int bonusNumber){
        validateRange(bonusNumber);
        validateBonusNumber(numbers, bonusNumber);
    }

    public static void validateSizing(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(NOT_NUMBER_SIZE);
            throw new IllegalArgumentException();
        }
    }
    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> overlapCheck = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            overlapCheck.add(numbers.get(i));
        }

        if (overlapCheck.size() != 6) {
            System.out.println(NOT_NUMBER_DUPLICATE);
            throw new IllegalArgumentException();
        }
    }

    public static void validateRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < MIN_NUMBER || numbers.get(i) > MAX_NUMBER) {
                System.out.println(NOT_NUMBER_RANGE);
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            System.out.println(NOT_NUMBER_RANGE);
            throw new IllegalArgumentException();
        }
    }

    public static int validateNumber(String amount) throws IllegalArgumentException {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            System.out.println(NOT_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    private static void validateNatural(int amount) {
        if (amount <= 0) {
            System.out.println(NOT_NATURAL_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    private static void validateDivisible(int amount) {
        if (amount % LOTTO_BUY_MIN != 0) {
            System.out.println(NOT_DIVISIBLE_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    public static int validateTypeInt(String inputNumber){
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            System.out.println(INPUT_TYPE_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            System.out.println(NOT_NUMBER_DUPLICATE);
            throw new IllegalArgumentException();
        }
    }
}
