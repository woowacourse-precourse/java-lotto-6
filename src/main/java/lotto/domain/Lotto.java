package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final Integer NUM_OF_LOTTO = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> intNumbers) {
        validateSize(intNumbers);
        List<LottoNumber> numbers = intNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        this.numbers = numbers;
    }



    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUM_OF_LOTTO) {
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
