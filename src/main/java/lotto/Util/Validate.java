package lotto.Util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String NOT_NUMBER_SIZE = "[ERROR] 당첨 번호는 6개 입력 가능합니다.";
    private static final String NOT_NUMBER_Duplicate = "[ERROR] 중복된 숫자를 입력하셨습니다.";
    private static final String NOT_NUMBER_RANGE = "[ERROR] 숫자는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이의 숫자여야 합니다.";

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
            System.out.println(NOT_NUMBER_Duplicate);
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

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            System.out.println(NOT_NUMBER_Duplicate);
            throw new IllegalArgumentException();
        }
    }
}
