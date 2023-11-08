package lotto.model;

import lotto.constant.response.Exception;

import java.util.*;

public class Lotto {
    public static final int SIZE = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = convertToLottoNumbers(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(Exception.ERROR_PREFIX.getMessage()
                    + Exception.LOTTO_SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != SIZE) {
            throw new IllegalArgumentException(Exception.ERROR_PREFIX.getMessage()
                    + Exception.LOTTO_DUPLICATE.getMessage());
        }
    }

    private List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .sorted(Comparator.comparing(LottoNumber::getNumber))
                .toList();

    }

    public int matchCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }

    public boolean hasNumber(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
