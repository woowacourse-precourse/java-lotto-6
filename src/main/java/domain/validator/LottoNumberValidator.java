package domain.validator;

import java.util.List;

public class LottoNumberValidator {

    public static void checkLottoValidation(List<Integer> numbers) {
        validate(numbers);
        isLottoContainDuplicateNumber(numbers);
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static void isLottoContainDuplicateNumber(List<Integer> numbers) {
        List<Integer> check = numbers.stream().distinct().toList();
        if(check.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
