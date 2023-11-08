package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.consts.ErrorMessage;
import lotto.util.consts.IntValueConst;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        List<Integer> generatedNumbers = generateNumbers();
        validate(generatedNumbers);
        this.numbers = generatedNumbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNotNull(numbers);
        validateEmptyLottoNumbers(numbers);
        validateNumbersSize(numbers);
        validateDuplicatedNumbers(numbers);
        validateNumbersInRange(numbers);
    }

    private void validateNotNull(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_LOTTO_NUMBERS.getMessage());
        }
    }

    private void validateEmptyLottoNumbers(List<Integer> numbers) {
        if (numbers.size() == 0) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_LOTTO_NUMBERS.getMessage());
        }
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != IntValueConst.LOTTO_FIXED_CIPHER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.UNCORRECT_LOTTO_NUMBER_SIZE.getMessage());
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS.getMessage());
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        numbers.forEach(this::validateEachNumberInRange);
    }

    private void validateEachNumberInRange(Integer n) {
        if (n < IntValueConst.START_INCLUSIVE_LOTTO_NUMBER.getValue() ||
                n > IntValueConst.END_INCLUSIVE_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                        IntValueConst.START_INCLUSIVE_LOTTO_NUMBER.getValue(),
                        IntValueConst.END_INCLUSIVE_LOTTO_NUMBER.getValue(),
                        IntValueConst.LOTTO_FIXED_CIPHER.getValue())
                .stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
