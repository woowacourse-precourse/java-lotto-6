package lotto;

import java.util.List;

public class ValidateUserNumber {
    public static void isLengthSix(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력 해주세요");
        }
    }

    public static void isValidNumber(List<String> numbers) {
        numbers.forEach(number -> {
            ValidateNumber.isNumber(number);
            isInRange(Integer.parseInt(number));
        });
    }

    public static void isInRange(Integer number) {
        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 숫자의 범위는 1부터 45까지 입니다.");
        }
    }

    public static void isDuplicate(List<String> numbers) {
        int check = (int) numbers.stream().distinct().count();
        if (numbers.size() != check) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력 해주세요.");
        }
    }
}
