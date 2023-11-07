package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.lotto.LottoNumberDuplicatedException;
import lotto.exception.lotto.LottoNumberSizeException;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(mapToLottoNumber(numbers));
    }

    private static List<LottoNumber> mapToLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::getInstance)
                .sorted()
                .toList();
    }

    private void validate(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateUniqueness(numbers);
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new LottoNumberSizeException(numbers);
        }
    }

    private void validateUniqueness(List<LottoNumber> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new LottoNumberDuplicatedException(numbers);
        }
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public int countMatchedNumber(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    @Override
    public String toString() {
        String numbersString = numbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", "));
        return String.format("[%s]", numbersString);
    }
}
