package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Lotto  {

    private static final int LENGTH = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                                                .map(number -> LottoNumber.of(number))
                                                .toList();
        validate(lottoNumbers);
        this.numbers = new ArrayList<>(lottoNumbers);
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public Stream<LottoNumber> stream() {
        return numbers.stream();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    // TODO: 추가 기능 구현
}
