package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> intNumbers) {
        validateSize(intNumbers);
        List<LottoNumber> numbers = intNumbers.stream()
                .map(intNumber -> new LottoNumber(intNumber))
                .collect(Collectors.toList());
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
