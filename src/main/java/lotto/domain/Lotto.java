package lotto.domain;

import static lotto.constants.LottoConstants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.constants.LottoConstants;

public class Lotto  {



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

    public Stream<LottoNumber> stream() {
        return numbers.stream();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public List<Integer> showNumbersByIntegers() {
        return numbers.stream()
                .map(LottoNumber::showNumber)
                .toList();
    }

    // TODO: 추가 기능 구현
}
