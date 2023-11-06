package lotto.domain;

import static lotto.constants.LottoConstants.LENGTH;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.exception.LottoNumbersDuplicationException;
import lotto.exception.WrongLottoLengthException;

public class Lotto {


    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {

        validate(numbers);

        List<LottoNumber> lottoNumbers = numbers.stream()
                                                .map(LottoNumber::valueOf)
                                                .toList();

        this.numbers = new ArrayList<>(lottoNumbers);
    }

    private void validate(List<Integer> numbers) {
        checkDuplication(numbers);
        checkLength(numbers);
    }

    private void checkDuplication(List<Integer> lotto) {
        List<Integer> distinctList = lotto.stream()
                                                .distinct()
                                                .toList();
        if (distinctList.size() != lotto.size()) {
            throw new LottoNumbersDuplicationException();
        }
    }

    private void checkLength(List<Integer> lotto) {
        if (lotto.size() != LENGTH) {
            throw new WrongLottoLengthException();
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
