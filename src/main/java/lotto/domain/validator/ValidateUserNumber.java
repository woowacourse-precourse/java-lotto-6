package lotto.domain.validator;

import java.util.List;

public class ValidateUserNumber {
    public static void isLengthSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력 해주세요");
        }
    }

    public static void isInRange(List<Integer> numbers) {
        if (check(numbers)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 1부터 45까지 입력 가능합니다.");
        }
    }

    private static boolean check(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number > 45 || number < 1);
    }

    public static void isDuplicate(List<Integer> numbers) {
        int check = (int) numbers.stream().distinct().count();
        if (numbers.size() != check) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력 해주세요.");
        }
    }
}
