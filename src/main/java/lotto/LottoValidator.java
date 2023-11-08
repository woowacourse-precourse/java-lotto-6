package lotto;

import java.util.List;

public class LottoValidator {

    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    public static void sizeValidate(List<Integer> numbers) {
        List<Integer> distinctNumber = numbers.stream()
                .distinct()
                .toList();
        if (distinctNumber.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 " + LOTTO_SIZE + "개의 숫자로 이루어져야 합니다.");
        }
    }

    public static void rangeValidateFromList(List<Integer> numbers) {
        numbers.forEach(LottoValidator::rangeValidate);
    }

    public static void rangeValidate(Integer number) {
        if ((number < LOTTO_MIN_NUMBER) || (number > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 번호는 " + LOTTO_MIN_NUMBER + " ~ " + LOTTO_MAX_NUMBER + " 사이의 숫자로 이루어져야 합니다.");
        }
    }
}
