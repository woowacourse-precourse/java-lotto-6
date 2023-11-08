package lotto.utils;

import java.util.List;
import lotto.constant.LottoConstant;

public class LottoNumberValidator {
    public static void validateNumber(Integer number) {
        if (!isProperLottoNumber(number)) {
            throw new IllegalArgumentException("로또 숫자는 1~45의 범위를 만족해야합니다.");
        }
    }

    public static void validateNumbers(List<Integer> numbers) {
        validateLengthCheck(numbers);
        validateDuplicateNumber(numbers);
        validateProperNumbers(numbers);
    }

    public static boolean isProperLottoNumber(Integer number) {
        return LottoConstant.MIN_NUMBER <= number && number <= LottoConstant.MAX_NUMBER;
    }

    private static void validateProperNumbers(List<Integer> number) {
        number.forEach(LottoNumberValidator::validateNumber);
    }

    private static void validateLengthCheck(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.SIZE) {
            throw new IllegalArgumentException(String.format("로또 번호의 갯수 %d개를 만족해야합니다.", LottoConstant.SIZE));
        }
    }

    private static void validateDuplicateNumber(List<Integer> numbers) {
        if (getDistinctCount(numbers) != LottoConstant.SIZE) {
            throw new IllegalArgumentException("숫자는 중복될 수 없습니다.");
        }
    }

    private static int getDistinctCount(List<Integer> numbers) {
        return (int) numbers.stream()
                .distinct()
                .count();
    }
}
