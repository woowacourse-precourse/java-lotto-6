package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.util.LottoValidator;

public class Lotto {
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortedNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validateLottoSize(numbers);
        LottoValidator.validateNumbersRange(numbers);
        LottoValidator.validateDuplicateLottoNumbers(numbers);
    }

    // TODO: 추가 기능 구현

    public boolean isContainsNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> sortedNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        String number = String.join(LOTTO_NUMBER_DELIMITER, numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList()));

        return String.format("[%s]", number);
    }
}
