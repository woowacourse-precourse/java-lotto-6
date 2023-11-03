package lotto.model;

import java.util.ArrayList;
import java.util.List;

public final class Lotto {
    private static final String DUPLICATED_LOTTO_NUMBER_EXCEPTION = "로또에 중복된 숫자가 있습니다.";
    private static final String LOTTO_SIZE_EXCEPTION = "로또는 6개의 숫자로 이루어져야 합니다.";
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> protectedNumbers = new ArrayList<>(numbers);
        validate(protectedNumbers);
        this.numbers = convert(protectedNumbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
    }

    private List<LottoNumber> convert(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .toList();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_EXCEPTION);
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER_EXCEPTION);
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != LOTTO_SIZE;
    }

    public static Lotto create(NumberGenerator numberGenerator) {
        List<Integer> uniqueNumbers = numberGenerator.generateUniqueNumbers(LottoNumber.MIN_NUMBER,
                LottoNumber.MAX_NUMBER,
                LOTTO_SIZE);
        return new Lotto(uniqueNumbers);
    }

}
