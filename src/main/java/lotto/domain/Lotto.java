package lotto.domain;

import java.util.List;
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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개로 구성되어야합니다.");
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
