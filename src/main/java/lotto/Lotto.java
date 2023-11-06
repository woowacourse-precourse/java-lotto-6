package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final int MAX_NUMBER_OF_NUMBERS = 6;
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumbers(numbers);
        createLottoNumbers(numbers);
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

    private void createLottoNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            this.lottoNumbers.add(new LottoNumber(number));
        }
    }

}
