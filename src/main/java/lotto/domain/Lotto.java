package lotto.domain;

import lotto.enums.ErrorMessages;
import lotto.enums.LottoEnum;
import lotto.utils.StringUtil;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public static Lotto valueOf(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .sorted()
                .map(LottoNumber::valueOf)
                .toList();
        return new Lotto(lottoNumbers);
    }

    public static Lotto valueOf(String stringNumbers) {
        return Lotto.valueOf(StringUtil.stringToList(stringNumbers));
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LottoEnum.SELECTED_NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.OVER_MAX_SIZE_MESSAGE.getMessage());
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.stream().map(LottoNumber::getNumber).distinct().count() != LottoEnum.SELECTED_NUMBERS_SIZE.getValue()) {
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
}
