package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private final static int BASE_UNIT = 1000;

    public void checkUnit(int number) {
        if (number == 0 || number % BASE_UNIT != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public void checkCount(int actualCount, int expectedCount) {
        if (actualCount != expectedCount) {
            throw new IllegalArgumentException(
                    expectedCount + "개의 당첨 번호를 입력해야 합니다."
            );
        }
    }

    public void checkRange(int number, int start, int end) {
        if (number < start) {
            throw new IllegalArgumentException(
                    "로또 번호는 " + start + "부터 " + end + " 사이의 숫자여야 합니다."
            );
        }

        if (number > end) {
            throw new IllegalArgumentException(
                    "로또 번호는 " + start + "부터 " + end + " 사이의 숫자여야 합니다."
            );
        }
    }

    public void checkDuplication(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException("당첨 번호에 중복이 없어야 합니다.");
        }
    }

    public void checkNull(String purchaseMoney) {
        if (purchaseMoney.equals("")) {
            throw new IllegalArgumentException("값을 입력하세요.");
        }
    }
}
