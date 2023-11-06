package lotto.valid;

import java.util.List;

public class LottoValidator extends Validator {

    public static void validate(List<Integer> numbers) throws IllegalArgumentException {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private static void validateLength(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개를 입력해주세요.");
        }
    }

    private static void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

}
