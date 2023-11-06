package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> intNumbers) {
        validateSize(intNumbers);
        List<LottoNumber> numbers = intNumbers.stream()
                .map(LottoNumber::new)
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

    public String lottoNumbers() {
        return numbers.stream()
                .map(LottoNumber::getLottoNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
