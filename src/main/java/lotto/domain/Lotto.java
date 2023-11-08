package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.consts.ErrorMessage;

import java.util.List;

import static lotto.util.consts.IntValueConst.START_INCLUSIVE_LOTTO_NUMBER;
import static lotto.util.consts.IntValueConst.END_INCLUSIVE_LOTTO_NUMBER;
import static lotto.util.consts.IntValueConst.LOTTO_FIXED_CIPHER;

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
        validateEmptyLottoNumbers(numbers);
        validateNumbersSize(numbers);
        validateDuplicatedNumbers(numbers);
        validateNumbersInRange(numbers);
    }

    private void validateEmptyLottoNumbers(List<Integer> numbers) {
        if (numbers.size() == 0) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_LOTTO_NUMBERS.getMessage());
        }
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_FIXED_CIPHER.getValue()) {
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
        if (n < START_INCLUSIVE_LOTTO_NUMBER.getValue() ||
                n > END_INCLUSIVE_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                        START_INCLUSIVE_LOTTO_NUMBER.getValue(),
                        END_INCLUSIVE_LOTTO_NUMBER.getValue(),
                        LOTTO_FIXED_CIPHER.getValue())
                .stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
