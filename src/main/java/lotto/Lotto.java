package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.LottoNumbersValidateEnum;
import lotto.service.MoneyValidateEnum;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortOfLotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        // 사이즈 검증
        validateSize(numbers);
        // 중복 검증
        validateDuplicatedNumber(numbers);
        // 범위 검증
        validateRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoNumbersValidateEnum.LOTTO_NUMBERS_SIZE_ERROR.get());
        }
    }

    private static void validateDuplicatedNumber(List<Integer> numbers) {
        boolean duplicate = numbers.stream().distinct().count() != numbers.size();

        if (duplicate) {
            throw new IllegalArgumentException(LottoNumbersValidateEnum.LOTTO_NUMBERS_DUPLICATE_ERROR.get());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        maxValidate(numbers);
        minValidate(numbers);
    }

    private static void maxValidate(List<Integer> numbers) {
        if (Collections.max(numbers) > 45) {
            throw new IllegalArgumentException(LottoNumbersValidateEnum.LOTTO_NUMBERS_RANGE_ERROR.get());
        }
    }

    private static void minValidate(List<Integer> numbers) {
        if (Collections.min(numbers) < 1) {
            throw new IllegalArgumentException(LottoNumbersValidateEnum.LOTTO_NUMBERS_RANGE_ERROR.get());
        }
    }

    // 로또 오름차순 정렬
    private static List<Integer> sortOfLotto(List<Integer> numbers) {
        List<Integer> result = new ArrayList<Integer>(numbers);
        Collections.sort(result);
        return result;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
