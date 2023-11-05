package lotto.model;

import java.util.List;

public class Lotto {

    private static final String LOTTO_NUMBER_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호가 중복됩니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return sortLottoNumber().toString();
    }
    
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (isNotLottoSizeSix(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNotLottoSizeSix(List<Integer> numbers) {
        return countUniqueLottoNumbers(numbers) != LottoConstants.LOTTO_NUMBER_SIZE;
    }

    private int countUniqueLottoNumbers(List<Integer> numbers) {
        return (int) numbers.stream()
                .distinct()
                .count();
    }

    private List<Integer> sortLottoNumber() {
        return numbers.stream()
                .sorted()
                .toList();
    }
}
