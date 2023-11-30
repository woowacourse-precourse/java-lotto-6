package lotto.view;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void validateThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
    public static void validateEmpty(String num) {
        String trimmedNum = num.trim();

        if (trimmedNum.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }

    public static void validateUnique(List<Integer> nums) {
        Set<Integer> uniqueNums = new HashSet<>(nums);

        if (uniqueNums.size() != nums.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public static void validateRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validatePositive(int input) {
        if (input < 1) {
            throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
        }
    }

    public static void validateNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 올바른 범위의 숫자를 입력하세요.");
        }
    }
}
