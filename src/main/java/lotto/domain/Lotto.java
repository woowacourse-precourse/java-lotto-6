package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        lottoNumbers = LottoNumber.getLottoNumbers(numbers);
    }

    public int getCorrectCount(Lotto anotherLotto) {
        return (int) lottoNumbers.stream().filter(anotherLotto::contains).count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자는 6개여야 합니다 : " + numbers.size() + "개");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        int distinctCount = calculateDistinctCount(numbers);
        if (distinctCount != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자는 중복될 수 없습니다");
        }
    }

    private int calculateDistinctCount(List<Integer> numbers) {
        return (int) numbers.stream().distinct().count();
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
