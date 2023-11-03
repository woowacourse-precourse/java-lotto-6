package lotto.domain.util.validator;

import java.util.List;

public class LottoValidator {
    public static void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplication(numbers);
    }

    private static void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkDuplication(List<Integer> numbers){
        // TODO: 2023-11-03 중복 검사
    }
}
