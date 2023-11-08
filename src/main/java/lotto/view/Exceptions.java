package lotto.view;

import java.util.List;

public class Exceptions {
    public static void validateDuplicateNum(int number, List<Integer> nums) {
        if (nums.contains(number)) {
            throw new IllegalArgumentException("중복된 번호가 존재합니다.");
        }
    }

    public static void validateLottoNum(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("번호는 1~45사이 값이여야 합니다.");
        }
    }

    public static void validateLottoLength(int length) {
        if (length != 6) {
            throw new IllegalArgumentException("입력된 번호의 길이는 6개여야합니다.");
        }
    }

    public static void validateNumber() {
        throw new IllegalArgumentException("입력 값은 정수여야 합니다.");
    }

    public static void validateExceedMinimum(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("구입금액은 1000원 보다 커야합니다.");
        }
    }

    public static void validateDivisibleAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("1000원으로 나누어떨어지지 않습니다");
        }
    }
}
