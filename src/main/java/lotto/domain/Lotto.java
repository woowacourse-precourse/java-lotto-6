package lotto.domain;

import java.util.List;

import static lotto.domain.NumberConverter.convertNumberToLottoNumber;

public class Lotto {
    public static final int MAX_NUMBER_OF_NUMBERS = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumbers(numbers);
        this.lottoNumbers = convertNumberToLottoNumber(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != MAX_NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        long count = numbers.stream()
                .distinct()
                .count();
        if (count != MAX_NUMBER_OF_NUMBERS) throw new IllegalArgumentException();
    }

}
