package lotto.domain;

import static lotto.exception.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.exception.ExceptionMessage.INVAILD_LOTTO_SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto { //Lotto = numbers
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateNonDuplicatedNumbers(numbers);
        validateLottoSize(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for(Integer number : numbers) {
            LottoNumber lottoNumber = new LottoNumber(number);
            lottoNumbers.add(lottoNumber);
        }
        return new Lotto(lottoNumbers);
    }

    private void validateNonDuplicatedNumbers(final List<LottoNumber> numbers) {
        List<LottoNumber> nonDuplicatedNumbers = numbers.stream().distinct().toList();
        if (nonDuplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateLottoSize(final List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVAILD_LOTTO_SIZE.getMessage());
        }
    }

    public List<LottoNumber> getLotto() {
        return Collections.unmodifiableList(numbers);
    }

}
