package lotto.validator;

import java.util.List;

public class LottoValidator{

    private static final int LOTTO_SIZE = 6;

    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);

    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또는 반드시 6개 숫자를 가져야 합니다.");
        }
    }

    private static void validateDuplicate(List<Integer> numbers){
        boolean duplicateExist = numbers.stream()
                .count() != LOTTO_SIZE;

        if (duplicateExist) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복 숫자가 존재합니다.");
        }
    }


}
