package domain.validator;

import util.ErrorMessage;

import java.util.List;

public class LottoValidator {

    public static void checkLottoValidation(List<Integer> numbers) {
        validate(numbers);
        isLottoContainDuplicateNumber(numbers);
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(ErrorMessage.LOTTO_MUST_CONTAIN_SIX_NUMBERS.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    private static void isLottoContainDuplicateNumber(List<Integer> numbers) {
        List<Integer> check = numbers.stream().distinct().toList();
        if(check.size() != numbers.size()) {
            System.out.println(ErrorMessage.LOTTO_CONTAIN_DULPICATE_NUMBER.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }
}
