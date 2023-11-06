package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers){
        return new Lotto(mapToLottoNumber(numbers));
    }

    private static List<LottoNumber> mapToLottoNumber(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::getInstance).toList();
    }

    private void validate(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateUniqueness(numbers);
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUniqueness(List<LottoNumber> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
