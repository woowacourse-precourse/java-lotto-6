package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = convertToLottoNumber(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(LottoErrorMessages.DUPLICATE_NUMBERS.getMessage());
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        int uniqueNumbersCount = (int) numbers.stream()
                .distinct()
                .count();
        return uniqueNumbersCount != numbers.size();
    }

    private List<LottoNumber> convertToLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    // TODO: 추가 기능 구현
}