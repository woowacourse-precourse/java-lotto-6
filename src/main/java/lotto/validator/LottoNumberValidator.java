package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {
    private LottoNumberValidator() {
    }

    // TODO: 숫자가 아닌 값이 들어오는 경우, INPUTVIEW에서 예외처리
    public static void validate(final List<Integer> numbers) {
        validateCountOfLottoNumbers(numbers);
        for (int number : numbers) {
            validateRangeOfEachNumber(number);
        }
        validateUniqueness(numbers);
    }

    private static void validateUniqueness(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException("로또 번호의 개수가 6개가 아닙니다.");
    }

    private static void validateRangeOfEachNumber(int number) {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException("로또 번호 중 범위를 벗어나는 값이 있습니다.");
    }

    private static void validateCountOfLottoNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size())
            throw new IllegalArgumentException("중복된 번호가 입력 되었습니다.");
    }
}
