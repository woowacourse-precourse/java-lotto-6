package lotto.domain;

import lotto.enums.ErrorMessages;
import lotto.enums.LottoEnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String SEPARATOR = ",";

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        validate(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public Lotto(String stringNumbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(stringNumbers.split(SEPARATOR))
                .sorted()
                .map(LottoNumber::new)
                .toList();
        validate(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LottoEnum.SELECTED_NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.OVER_MAX_SIZE_MESSAGE.getMessage());
        }
        if (lottoNumbers.stream().mapToInt(LottoNumber::getNumber).distinct().count() != LottoEnum.SELECTED_NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NUMBER_MESSAGE.getMessage());
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.numbers.stream().anyMatch(number -> number.getNumber() == lottoNumber.getNumber());
    }

    public int countMatchedNumbers(Lotto winningLotto) {
        return numbers.stream()
                .filter(winningLotto::contains)
                .map(lottoNumber -> 1)
                .reduce(0, Integer::sum);
    }

    public List<LottoNumber> getLottoNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.stream().map(LottoNumber::getNumber).toList().toString();
    }

    public String toHash() {
        return super.toString();
    }
}
