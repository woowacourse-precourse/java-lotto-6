package lotto;

import java.util.List;

public class Validation {
    public void isAllNumber(String string) {
        if (!string.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해 주세요.\n");
        }
    }

    public void isDivisibleByThousand(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.\n");
        }
    }

    public void isBetweenRangeNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.\n");
        }
    }

    public void isNotDuplicated(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.\n");
        }
    }
}
