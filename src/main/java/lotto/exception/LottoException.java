package lotto.exception;

import java.util.List;

public class LottoException extends IllegalArgumentException {

    public LottoException(String message) {
        super(message);
    }

    public static void ensureValidSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void ensureDistinctNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public static void ensureNumbersWithinRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자만 가능합니다.");
        }
    }
}
